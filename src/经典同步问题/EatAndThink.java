package 经典同步问题;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harvey
 * @date 2020/7/21
 * @slogan Drive business with technology, make business generate value.
 */
public class EatAndThink implements Runnable{
    private ReentrantLock lockL;
    private  ReentrantLock lockR;
    public EatAndThink(ReentrantLock lockL,ReentrantLock lockR){
        this.lockL=lockL;
        this.lockR=lockR;
    }
    @Override
    public void run() {
        while (true){
            synchronized (this){
               /*if ((!lockR.isLocked())&&(!lockL.isLocked())){
                   lockL.lock();*/
                if (lockR.tryLock()&&lockL.tryLock()){

                    System.out.println(Thread.currentThread().getName()+" 我拿到了左边的筷子");
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lockR.lock();//然后拿右边的筷子
                    System.out.println(Thread.currentThread().getName()+" 我拿到了右边的筷子");
                    System.out.println(Thread.currentThread().getName() +"  开始吃饭了");

                }
               /*
               lockR.unlock();*/
                System.out.println(Thread.currentThread().getName()+" 科学家放下手中的筷子，开始去思考了");
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
