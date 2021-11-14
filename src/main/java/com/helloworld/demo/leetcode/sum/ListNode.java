package com.helloworld.demo.leetcode.sum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }