package com.helloworld.demo.javase;

public class TestOdd {

    public static void main(String[] args) {
        System.out.println(isOdd(1));
        System.out.println(isOdd(2));
        System.out.println(isOdd(3));
        System.out.println(isOdd(-1));
        System.out.println(isOdd(-2));
        System.out.println(isOdd(-3));
        System.out.println(isOdd(0));
    }


    /**
     *  是否是奇数
     *  正数 对2取余 结果0/1
     *  负数 对2取余 结果0/-1
     *
     *  结果只有0 1 -1
     *
     * @param number
     * @return
     */
    public static boolean isOdd(int number){
        //return number%2 == 1 || number%2 == -1;
        //return number%2 != 0;
        return (number&1) == 1;
    }


}
