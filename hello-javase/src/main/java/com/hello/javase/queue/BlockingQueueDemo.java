package com.hello.javase.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) {

        //不存储队列元素，只存储一个元素，取出后在存储
        BlockingQueue blockingQueue = new SynchronousQueue();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put 1");
                blockingQueue.put("1");

                System.out.println(Thread.currentThread().getName() + " put 2");
                blockingQueue.put("2");

                System.out.println(Thread.currentThread().getName() + " put 3");
                blockingQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();


        //3秒取出一个，1、2、3分别3秒后取出一个
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

    }
}
