package com.helloworld.demo.javase.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 多线程操作资源类
 */
class ShareData {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increament() {
        lock.lock();
        try {
            //如果不为0，阻塞等待
            while (number != 0) {
                condition.await();
            }
            //为0加1
            number++;
            System.out.println(Thread.currentThread().getName() + " increament " + number);
            //加1后唤醒消费线程消费
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                //为0不能在减
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + " decrement " + number);
            //减1后唤醒生产 线程生产
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadCommunicationDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                shareData.increament();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                shareData.decrement();
            }
        }, "B").start();

    }
}
