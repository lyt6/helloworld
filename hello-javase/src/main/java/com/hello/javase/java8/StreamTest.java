package com.hello.javase.java8;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        //distinct
        Stream.of(1,2,3,5,5,2,6).distinct().forEach(System.out::println);
        //order
        Stream.of(1, 5, 3, 4, 2).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        // order reverse
        Stream.of(1, 5, 3, 4, 2).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        // range
        IntStream.range(1,3).forEach(System.out::println);
    }

}
