package com.helloworld.demo.design;

/**
 * 双重锁单利模式
 * 只有在第一次初始化的时候使用同步锁，提高性能
 */
public class Singleton {
    private volatile static Singleton instance = null;
    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
