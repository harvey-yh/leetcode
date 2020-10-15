package 经典同步问题;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harvey
 * @date 2020/9/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 生产者消费者ReentrantLock<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        try {
            lock.lock();
            while(lists.size() == MAX) {
                producer.await();
            }
            lists.add(t);
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while(lists.size() == 0) {
                consumer.await();
            }
            t = lists.removeFirst();
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        生产者消费者ReentrantLock<String> c = new 生产者消费者ReentrantLock<>();
        //启动生产者线程
        new Thread(()->{
            for(int j=0; j<25; j++) {
                c.put(j+"");
                System.out.println("生产者"+Thread.currentThread().getName()+"生产了"+j);
            }
        }, "p").start();

        //启动消费者线程25个
        for(int i=0; i<5; i++) {
            new Thread(()->{
                for(int j=0; j<5; j++) {
                    System.out.println("消费者"+Thread.currentThread().getName()+"消费了  "+c.get());
                }
            }, "c" + i).start();
        }
    }
}
