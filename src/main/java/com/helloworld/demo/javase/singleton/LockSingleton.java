package com.helloworld.demo.javase.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSingleton {
    static Lock lock = new ReentrantLock();
    private static LockSingleton instance = null;

    private LockSingleton() {
    }

    public static LockSingleton getInstance() {
        try {
            lock.lock();
            if (instance == null) {
                instance = new LockSingleton();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public static void main(String[] args) {
        LockSingleton instance = LockSingleton.getInstance();
        System.out.println("main thread instance is ---- > " + instance);
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " ---- >   " + LockSingleton.getInstance())).start();
    }

}
