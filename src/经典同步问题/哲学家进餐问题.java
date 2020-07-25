package 经典同步问题;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harvey
 * @date 2020/7/21
 * @slogan Drive business with technology, make business generate value.
 */
public class 哲学家进餐问题 {
    static class FiveLock {
        static Object lock0=new Object();
        static Object lock1=new Object();
        static Object lock2=new Object();
        static Object lock3=new Object();
        static Object lock4=new Object();
    }

    static class FiveReentrantLockLock {//分别代表5双筷子
        static ReentrantLock lock0=new ReentrantLock();
        static ReentrantLock lock1=new ReentrantLock();
        static ReentrantLock lock2=new ReentrantLock();
        static ReentrantLock lock3=new ReentrantLock();
        static ReentrantLock lock4=new ReentrantLock();
    }

    // 死锁
    public static void main(String[] args) {
        Thread perple0=new Thread(new eatThink(FiveLock.lock0,FiveLock.lock1),"科学家0");
        Thread perple1=new Thread(new eatThink(FiveLock.lock1,FiveLock.lock2),"科学家1");
        Thread perple2=new Thread(new eatThink(FiveLock.lock2,FiveLock.lock3),"科学家2");
        Thread perple3=new Thread(new eatThink(FiveLock.lock3,FiveLock.lock4),"科学家3");
        Thread perple4=new Thread(new eatThink(FiveLock.lock4,FiveLock.lock0),"科学家4");
        perple0.start();
        perple1.start();
        perple2.start();
        perple3.start();
        perple4.start();
    }

        //synchronized
//    public static void main(String[] args) {
//        Thread perple0=new Thread(new eatAndThink(FiveLock.lock1,FiveLock.lock0),"科学家0");
//        Thread perple1=new Thread(new eatAndThink(FiveLock.lock1,FiveLock.lock2),"科学家1");
//        Thread perple2=new Thread(new eatAndThink(FiveLock.lock3,FiveLock.lock2),"科学家2");
//        Thread perple3=new Thread(new eatAndThink(FiveLock.lock3,FiveLock.lock4),"科学家3");
//        Thread perple4=new Thread(new eatAndThink(FiveLock.lock0,FiveLock.lock4),"科学家4");
//        perple0.start();
//        perple1.start();
//        perple2.start();
//        perple3.start();
//        perple4.start();
//    }

//    public static void main(String[] args) {
//        Thread perple0=new Thread(new eatAndThink(FiveReentrantLockLock.lock0,FiveReentrantLockLock.lock1),"科学家0");
//        Thread perple1=new Thread(new eatAndThink(FiveReentrantLockLock.lock1,FiveReentrantLockLock.lock2),"科学家1");
//        Thread perple2=new Thread(new eatAndThink(FiveReentrantLockLock.lock2,FiveReentrantLockLock.lock3),"科学家2");
//        Thread perple3=new Thread(new eatAndThink(FiveReentrantLockLock.lock3,FiveReentrantLockLock.lock4),"科学家3");
//        Thread perple4=new Thread(new eatAndThink(FiveReentrantLockLock.lock4,FiveReentrantLockLock.lock0),"科学家4");
//        perple0.start();
//        perple1.start();
//        perple2.start();
//        perple3.start();
//        perple4.start();
//    }
}

/**
 * synchronized写法
 */
class eatThink implements Runnable{
    private  Object lockL;
    private  Object lockR;
    public eatThink(Object lockL,Object lockR){
        this.lockL=lockL;
        this.lockR=lockR;
    }
    @Override
    public void run() {
        while (true){
            synchronized (lockL){ //先拿左边的筷子
                System.out.println(Thread.currentThread().getName()+" 我拿到了左边的筷子");
                try {
                    Thread.sleep(2);//让死锁发生更快
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockR){ //然后拿右边的筷子
                    System.out.println(Thread.currentThread().getName()+" 我拿到了右边的筷子");
                    System.out.println(Thread.currentThread().getName() +"  开始吃饭了");
                }
            }
            System.out.println(Thread.currentThread().getName()+" 科学家放下手中的筷子，开始去思考了");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

/**
 * Reentrantlock
 */
//class eatAndThink implements Runnable{
//    private ReentrantLock lockL;
//    private  ReentrantLock lockR;
//    public eatAndThink(ReentrantLock lockL,ReentrantLock lockR){
//        this.lockL=lockL;
//        this.lockR=lockR;
//    }
//    @Override
//    public void run() {
//
//        while (true){
//            synchronized (this){
//               /*if ((!lockR.isLocked())&&(!lockL.isLocked())){
//                   lockL.lock();*/
//                if (lockR.tryLock()&&lockL.tryLock()){
//
//                    System.out.println(Thread.currentThread().getName()+" 我拿到了左边的筷子");
//                    try {
//                        Thread.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    lockR.lock();//然后拿右边的筷子
//                    System.out.println(Thread.currentThread().getName()+" 我拿到了右边的筷子");
//                    System.out.println(Thread.currentThread().getName() +"  开始吃饭了");
//
//                }
//               /*
//               lockR.unlock();*/
//                System.out.println(Thread.currentThread().getName()+" 科学家放下手中的筷子，开始去思考了");
//                try {
//                    Thread.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//
//    }
//}