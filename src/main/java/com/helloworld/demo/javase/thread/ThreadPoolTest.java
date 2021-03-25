package com.helloworld.demo.javase.thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            integers.add(i);

        }
        integers.parallelStream().forEach(i -> {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " ---- " + i);
            });
        });
        executorService.shutdown();
    }
}
