package com.hello.javase.juc;

/**
 * volatile单利锁 - 懒汉式
 */
public class VolatileSingleton {

    public VolatileSingleton() {
    }

    //双端检锁机制 volatile禁止指令重排序（编译器重排、指令重排、内存重排）
    private static volatile VolatileSingleton instance = null;

    public static VolatileSingleton getInstance() {
        if (instance == null) {
            synchronized (VolatileSingleton.class) {
                if (instance == null) {
                    instance = new VolatileSingleton();
                }
            }
        }
        return instance;
    }
}
