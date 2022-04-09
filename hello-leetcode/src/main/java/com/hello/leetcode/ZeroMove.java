package com.hello.leetcode;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class ZeroMove {

    /**
     * left point not zero
     * right point zero
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 1) return;
        int n = nums.length,left = 0,right = 0;
        while(right < n){
            if(nums[right] != 0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
