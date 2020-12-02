package com.helloworld.demo.javase.juc;


import java.util.concurrent.TimeUnit;

class LockThread implements Runnable{
    String lockA;
    String lockB;
    public LockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+" has lockA try get lock B ... ");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+" has lockB try get lock A ... ");
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new LockThread(lockA,lockB),"A").start();
        new Thread(new LockThread(lockB,lockA),"B").start();
    }
}
