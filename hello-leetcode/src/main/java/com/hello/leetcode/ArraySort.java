package com.hello.leetcode;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class ArraySort {

    /**
     * 冒泡排序
     * var arr = [10, 209, 30, 4, 57]
     * 1、外层循环-》交换次数
     * 2、内层循环 - 》 比较并交换
     *
     * @param nums
     * @return
     */
    public static int[] maopao(int[] nums) {
        //n个数排序比较n-1次，内循环每次比较后减少一个比较的数
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序
     *
     * @param nums
     * @return
     */
    public static int[] selectSort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] binarySearch(int[] nums) {

        /**
         * 选择排序
         * 1、外层循环 -》 循环比较次数
         * 2、内层循环 -》 开始比较并交换
         */
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length - 1; j++) {

            }
        }


        return nums;
    }


    public static void main(String[] args) {

        //maopao
        int[] arr = new int[]{10, 209, 30, 4, 57};
        int[] maopao = binarySearch(arr);
        for (int i : maopao) {
            System.out.println(i);
        }
//        //select
//        int[] selectSort = selectSort(arr);
//        for (int i : selectSort) {
//            System.out.println(i);
//        }


    }
}
