package com.helloworld.demo.javase.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+" thread count--");
            },String.valueOf(i)).start();
        }

        //等6个线程都执行完再执行以下代码
        countDownLatch.await();
        System.out.println("now countDownLatch is zero!");
    }
}
