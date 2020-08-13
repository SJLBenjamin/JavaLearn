package com.example.myjavalib.rwLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLock {
    int mNumber = 0;
     ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final RWLock rwLock=new RWLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.setNumber(5);
            }
        }).start();

        for (int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rwLock.get();
                }
            }).start();
        }
    }

    public void setNumber(int number){
        try {
            reentrantReadWriteLock.writeLock().lock();
            mNumber =number;
            System.out.println("write began Name=="+Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("write end Name=="+Thread.currentThread().getName());
        }catch (Exception e){

        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
       // System.out.println(Thread.currentThread().getName()+"===="+mNumber);
    }

    public void get(){
        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println("read began Name=="+Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("read end Name=="+Thread.currentThread().getName());
        }catch (Exception e){

        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
       // System.out.println(Thread.currentThread().getName()+"===="+mNumber);
    }
}
