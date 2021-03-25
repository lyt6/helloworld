package com.helloworld.demo.leetcode;

/**
 * binary search
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (target == nums[middle]) return middle;
            if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(ints, 8));
    }

}
