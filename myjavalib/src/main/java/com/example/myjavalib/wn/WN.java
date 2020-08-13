package com.example.myjavalib.wn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WN {

    static  Lock lock=new ReentrantLock(true);
    static  Condition condition;
    public static void main(String[] args) {

//         condition = lock.newCondition();
//
//        for (int i=0;i<5;i++){
//            new Thread(){
//                @Override
//                public void run() {
//                    super.run();
//                    new WN().MyLockWait();
//                }
//            }.start();
//        }


        new WN().MyLockNotify();


        for (int i=0;i<5;i++){
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    new WN().MyWait();
                }
            }.start();
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WN().MyNotify();
    }



    public  void MyWait(){
        synchronized (WN.class){
            try {
                System.out.println("wait began=="+Thread.currentThread().getName());
                WN.class.wait();
                System.out.println("wait after=="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void MyNotify(){
        synchronized (WN.class){
            WN.class.notifyAll();
        }
    }


    public  void MyLockWait(){
        lock.lock();
            try {
                System.out.println("wait began=="+Thread.currentThread().getName());
               condition.await();
                System.out.println("wait after=="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }

    }

    public void MyLockNotify(){
            condition.signal();
    }

}
