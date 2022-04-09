package com.hello.leetcode;


import java.util.Stack;

public class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack();
        out = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        inToOut();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        inToOut();
        return out.peek();
    }

    private void inToOut() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

}
