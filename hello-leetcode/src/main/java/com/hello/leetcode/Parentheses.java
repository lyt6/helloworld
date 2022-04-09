package com.hello.leetcode;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Stack;

public class Parentheses {

    public static boolean isParentheses(String s){
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put('(',')');
        dict.put('[',']');
        dict.put('{','}');
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if(dict.get(c) != null){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(dict.get(stack.pop()) != c){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static boolean isParentheses2(String s){
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(!stack.isEmpty() && stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = ")";
        System.out.println(isParentheses(s1));
        String s2 = ")(){}";
        System.out.println(isParentheses(s2));
    }
}
