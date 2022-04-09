package com.hello.javase.queue;


import org.springframework.util.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程共享资源
 * 生产、消费同时进行，开关控制停止作业
 */
class MyData {
    private volatile Boolean flag = Boolean.TRUE;//true开始生产消费
    private AtomicInteger atomicInteger = new AtomicInteger();// default 0

    private BlockingQueue<String> blockingQueue = null;

    public MyData(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("传输实现类--->" + blockingQueue.getClass().getName());
    }

    /**
     * 一直生产
     */
    public void product() {
        String data;
        boolean offerResult;
        while (flag) {
            data = String.valueOf(atomicInteger.incrementAndGet());
            try {
                offerResult = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offerResult) {
                    System.out.println("into queue success " + data);
                } else {
                    System.out.println("into queue fail " + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" product stop ...");
    }

    /**
     * 一直消费
     */
    public void consume() {
        String pollResult;
        while (flag) {
            try {
                pollResult = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (StringUtils.isEmpty(pollResult)) {
                    System.out.println("poll queue  two second empty set flag false to stop ...");
                    flag = Boolean.FALSE;
                    return;
                }
                System.out.println("poll queue success " + pollResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("consume stop ... ");
    }

    /**
     * stop product and consume
     */
    public void stop() {
        this.flag = Boolean.FALSE;
    }

}

/**
 * 使用消息队列方式实现线程通信
 */
class ThreadCommunication3 {
    public static void main(String[] args) throws InterruptedException {
        MyData myData = new MyData(new ArrayBlockingQueue<>(3));
        new Thread(() -> {
            System.out.println("product thread start ... ");
            myData.product();
        }, "product thread").start();
        new Thread(() -> {
            System.out.println("consume thread start ... ");
            myData.consume();
        }, "consume thread").start();

        //一直生产消费5秒钟后停止
        TimeUnit.SECONDS.sleep(5);
        System.out.println("five second stop task  。。。");
        myData.stop();
    }

}
