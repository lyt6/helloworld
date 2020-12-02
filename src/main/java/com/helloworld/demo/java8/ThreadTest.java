package com.helloworld.demo.java8;

public class ThreadTest {
    public static void main(String[] args) {
        int i = 123;
        Runnable runnable = ()->{
            System.out.println(i);
        };
        runnable.run();
    }
}
