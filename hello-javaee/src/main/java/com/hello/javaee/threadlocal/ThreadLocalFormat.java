package com.hello.javaee.threadlocal;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalFormat {

    private static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);

    public static void main(String[] args) {
        executorService.submit(()->{
            
        });
    }

}
