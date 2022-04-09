package com.hello.javase.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        Vector<String> vector = new Vector<>();
        List<String> syncArrayList = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        //解决arrayList 线程安全的list
        //1、使用vector
        //2、使用Collections.synchronizedList(new ArrayList<>());
        //3、readWrightArrayList

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                String uuid = UUID.randomUUID().toString().substring(0, 8);
//                arrayList.add(uuid);
//                vector.add(uuid);
//                syncArrayList.add(uuid);
                copyOnWriteArrayList.add(uuid);
                System.out.println(copyOnWriteArrayList);
            }).start();
        }
    }
}
