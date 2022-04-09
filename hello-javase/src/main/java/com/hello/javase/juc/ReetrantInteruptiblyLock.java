package com.hello.javase.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可中断的ReetrantLock
 */
public class ReetrantInteruptiblyLock {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        /**
         * 启动两个线程，首先A拿lock1，B拿lock2，10ms后，A和B都呗两个线程占用后，A再拿lock2，B再拿lock1
         */
        Thread threadA = new Thread(new RunableDemo(lock1, lock2), "A");
        Thread threadB = new Thread(new RunableDemo(lock2, lock1), "B");
        threadA.start();
        threadB.start();

        //中断第一个线程
        threadA.interrupt();
    }

    static class RunableDemo implements Runnable {
        Lock lock1;
        Lock lock2;

        public RunableDemo(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            System.out.println("thread " + Thread.currentThread().getName() + " ni ");
            try {
                lock1.lockInterruptibly();
                TimeUnit.MICROSECONDS.sleep(10);
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
                System.out.println("thread " + Thread.currentThread().getName() + " normal over ");
            }
        }
    }


}
