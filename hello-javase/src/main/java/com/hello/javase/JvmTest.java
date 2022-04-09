package com.hello.javase;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class JvmTest {
    public static void main(String[] args) {
        try {
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
            //size Integer.Max_VALUE
            LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
            //是否公平阻塞队列
            SynchronousQueue synchronousQueue = new SynchronousQueue(true);
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
