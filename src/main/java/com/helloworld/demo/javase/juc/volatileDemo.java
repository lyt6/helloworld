package com.helloworld.demo.javase.juc;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class IntegerData {
    volatile Integer number = 0;

    public void addData() {
        number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }
}

public class volatileDemo {
    public static void main(String[] args) {
        //1、volatile保证可见性
        //testVolatileVisible();

        //2、volatile 不保证原子性
        IntegerData integerData = new IntegerData();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    integerData.addPlusPlus();
                    integerData.addMyAtomic();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("integer = " + integerData.number);
        System.out.println("atomic integer = " + integerData.atomicInteger);

    }

    private static void testVolatileVisible() {
        IntegerData integerData = new IntegerData();
        new Thread(() -> {
            System.out.println("update thread init value = " + integerData.number);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //sleep three second update tree value
            integerData.addData();
            System.out.println("update thread updated value = " + integerData.number);
        }).start();
        while (integerData.number == 0) {
            //感知data是否发生改变
        }
        //不为0会继续执行
        System.out.println("main thread read update value = " + integerData.number);
    }
}
