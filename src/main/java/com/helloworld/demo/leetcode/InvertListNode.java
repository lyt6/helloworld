package com.helloworld.demo.leetcode;

public class InvertListNode {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
             ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean hasCycle(ListNode head) {
      ListNode quick = head;
      ListNode slow = head;
      while(quick != null && quick.next != null){
          quick = quick.next.next;
          slow = slow.next;
          if(quick == slow){
              return true;
          }
      }
      return false;
    }
}
