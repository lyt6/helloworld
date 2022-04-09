package com.hello.javase.thread;

import java.util.concurrent.SynchronousQueue;

public class RuntimeTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        SynchronousQueue<Runnable> runnables = new SynchronousQueue<>();
        System.out.println(runnables.size());
    }
}
