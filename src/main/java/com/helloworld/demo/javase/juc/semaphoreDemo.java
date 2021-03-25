package com.helloworld.demo.javase.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class semaphoreDemo {
    public static void main(String[] args) {
        //假如有三个停车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到车位！");
                    //占用车位3秒
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + " 停车3秒后离开！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
