package com.hello.javase.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A线程打印5次，B线程打印10次，C线程打印15次，按照此顺序打印5轮（线程依次打印）
 */
class ShareSource {
    private int number = 1;//线程标识 A：1 B：2 C：3
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    //判断 干活 通知
    public void print5() {
        try {
            lock.lock();
            while (number != 1) {
                condition1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;//修改多线程标识
            condition2.signal();//唤醒B线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //判断 干活 通知
    public void print10() {
        try {
            lock.lock();
            while (number != 2) {
                condition2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;//修改多线程标识
            condition3.signal();//唤醒B线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //判断 干活 通知
    public void print15() {
        try {
            lock.lock();
            while (number != 3) {
                condition3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;//修改多线程标识
            condition1.signal();//唤醒B线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LockConditionDemo {
    public static void main(String[] args) {
        ShareSource shareSource = new ShareSource();

        new Thread(() -> {
            //5轮
            for (int i = 1; i <= 5; i++) {
                shareSource.print5();
            }
        }, "A").start();

        new Thread(() -> {
            //5轮
            for (int i = 1; i <= 5; i++) {

                shareSource.print10();
            }
        }, "B").start();

        new Thread(() -> {
            //5轮
            for (int i = 1; i <= 5; i++) {
                shareSource.print15();
            }
        }, "C").start();
    }
}
