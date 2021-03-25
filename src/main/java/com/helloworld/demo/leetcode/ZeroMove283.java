package com.helloworld.demo.leetcode;

/**
 * 移动零
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class ZeroMove283 {

    /**
     * 使用新数组
     *
     * @param nums
     */
    public static void method1(int[] nums) {
        if (nums == null) {
            return;
        }
        int[] tempArray = new int[nums.length];
        int tempIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //正数、负数
            if (nums[i] != 0) {
                tempArray[tempIndex++] = nums[i];
            }
        }
        for (int i = 0; i < tempArray.length; i++) {
            nums[i] = tempArray[i];
        }
    }

    /**
     * 直接将nums元素移动（非0元素移动到最前面，最后将后面的设置为0）
     *
     * @param nums
     */
    public static void method2(int[] nums) {
        if (nums == null) {
            return;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    /**
     * 非零和零元素直接交换位置
     * [1,1,3,12,0,0]
     *
     * @param nums
     */
    public static void method3(int[] nums) {
        if (nums == null) {
            return;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                if (i != k) {
                    nums[i] = 0;
                }
                k++;
            }
        }
    }


}
