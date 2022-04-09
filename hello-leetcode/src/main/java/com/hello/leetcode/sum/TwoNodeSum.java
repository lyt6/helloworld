package com.hello.leetcode.sum;

import java.util.HashMap;
import java.util.Map;

public class TwoNodeSum {

    public static ListNode twoNodeSum(ListNode l1, ListNode l2){
       ListNode dummyNode = new ListNode(0);
       ListNode head = dummyNode;
       int upNumber = 0;
       while(l1 != null || l2 != null || upNumber > 0){
           int l1Val = l1 == null ? 0 :l1.val;
           int l2Val = l2 == null ? 0 :l2.val;
           int sum = l1Val + l2Val + upNumber;
           head.next = new ListNode(sum % 10);
           head = head.next;
           upNumber = sum / 10;
           if(l1 != null) l1 = l1.next;
           if(l2 != null) l2 = l2.next;
       }
        return dummyNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        int up = 0;
        while(l1 != null || l2 != null || up != 0){
            int l1Val =  l1 == null?0:l1.val;
            int l2Val =  l2 == null?0:l2.val;
            int sum = l1Val + l2Val + up;
            // set next and move
            head.next = new ListNode(sum % 10);
            head = head.next;
            up = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        //l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        ListNode l1 = ListNode.builder()
                .next(ListNode.builder().val(9).build())
                .next(ListNode.builder().val(9).build())
                .next(ListNode.builder().val(9).build())
                .next(ListNode.builder().val(9).build())
                .next(ListNode.builder().val(9).build())
                .next(ListNode.builder().val(9).build())
                .next(ListNode.builder().val(9).build())
                .build();
        ListNode l2 = ListNode.builder()
                .next(ListNode.builder().val(9).build())
                .next(ListNode.builder().val(9).build())
                .next(ListNode.builder().val(9).build())
                .next(ListNode.builder().val(9).build())
                .build();

        ListNode listNode = twoNodeSum(l1, l2);
        while(listNode != null && listNode.next != null){
            listNode = listNode.next;
            System.out.println(listNode.val);
        }

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length;i ++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
