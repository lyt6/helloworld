package com.hello.javase.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws InterruptedException {
        System.out.println("come in callable call ... ");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask(new MyCallable());
        new Thread(futureTask, "A").start();
        try {
            int number = 100;
            //会阻塞一直等到call执行完成
            System.out.println(number + futureTask.get());
            while (!futureTask.isDone()) {
                futureTask.wait();
            }
            System.out.println("call done ... ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


