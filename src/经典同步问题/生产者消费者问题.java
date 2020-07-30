package 经典同步问题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harvey
 * @date 2020/7/28
 * @slogan Drive business with technology, make business generate value.
 */
public class 生产者消费者问题 {
    public static void main(String[] args) {
        // 高内聚，低耦合 内聚指的是，一个空调，自身带有调节温度高低的方法
        ShareData shareData = new ShareData();

        // t1线程，生产
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        // t2线程，消费
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }
}
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment(){
        // 同步代码块，加锁
        lock.lock();
        try {
            while(number >= 5) {
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);

            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        // 同步代码块，加锁
        lock.lock();
        try {
            while(number == 0) {
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);

            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
//class ProdConsumerTraditionDemo {
//
//    public static void main(String[] args) {
//
//        // 高内聚，低耦合    内聚指的是，一个空调，自身带有调节温度高低的方法
//
//        ShareData shareData = new ShareData();
//
//        // t1线程，生产
//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    shareData.increment();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "t1").start();
//
//        // t2线程，消费
//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    shareData.decrement();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "t2").start();
//    }
//}