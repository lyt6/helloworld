package com.helloworld.demo.javase;

public class EqualsAndCompare {
    public static void main(String[] args) {
        Integer i = 1;
        Integer i2 = 1;
        Long l = 1L;

        //1、基本类型比较的是值
        System.out.println(i == i2);

        //2、引用类型
        // 先比较类型(类型不相同不可比较)，类型相同在比较大小
        //没有重写equals比较的时候地址值（重写后比较的是值）
        //System.out.println(i == l);
        System.out.println(i.equals(i2));

    }
}
