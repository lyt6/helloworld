package com.helloworld.demo;

public class Interview {

    public static void question1_method1(){
        String s  = "how are you";
        String s1 = s.replaceAll(" ", "%20");
        System.out.println(s1);
    }
    public static void question1_method2(){
        String s  = "how are you";
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == ' '){
                builder.append("%20");
            }else{
                builder.append(c);
            }
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        question1_method1();
        question1_method2();
    }

}
