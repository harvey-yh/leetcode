package 经典同步问题;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harvey
 * @date 2020/7/21
 * @slogan Drive business with technology, make business generate value.
 */
public class FiveEat {
    public static void main(String[] args) {
        //定义一个线程池，四个线程。保证最多四个哲学家同时拿到左边的筷子。
        ExecutorService executorService= new ThreadPoolExecutor(4,4,0L, TimeUnit.SECONDS,new LinkedBlockingQueue());
        //定义五个筷子
        Object [] lock=new Object[5];
        for (int i=0;i<5;i++){
            lock[i]=new ReentrantLock();
        }
        while (true){
            //定义一个随机数，用来获取某一哲学家左右两只筷子
            int a=new Random().nextInt(5);
            executorService.submit(new EatAndThink((ReentrantLock)lock[a],(ReentrantLock)lock[(a+1)%5]));
        }
    }
}

