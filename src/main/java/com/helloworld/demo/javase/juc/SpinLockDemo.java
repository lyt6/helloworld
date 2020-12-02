package com.helloworld.demo.javase.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        System.out.println(Thread.currentThread().getName()+" invoked lock");
        while (!atomicReference.compareAndSet(null,Thread.currentThread())){
            //不是null就自旋
        }
    }

    public void unLock(){
        System.out.println(Thread.currentThread().getName()+" invoked unlock ");
        atomicReference.compareAndSet(Thread.currentThread(),null);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

       new Thread(()->{
            spinLockDemo.lock();
            try {
                System.out.println("A using begin");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("A using end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        },"A").start();

       //暂停1秒钟，让A线程先执行
        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            spinLockDemo.lock();
            spinLockDemo.unLock();
        },"B").start();
    }

}
