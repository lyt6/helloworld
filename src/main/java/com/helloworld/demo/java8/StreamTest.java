package com.helloworld.demo.java8;

import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

//        Stream.of(1,2,3,5,5,2,6).distinct().forEach(System.out::println);

//        Stream.of(1,2,3).map(i->i*10).forEach(System.out::println);

        //flatMap返回值必须是Stream
//        Stream.of(1,2,3).flatMap(i->Stream.of(i*10)).forEach(System.out::println);

        Stream.of(1,2,3,4,5).sorted().forEach(System.out::println);
//        Stream.of(3,2,1).sorted().forEach(System.out::println);

    }
}
