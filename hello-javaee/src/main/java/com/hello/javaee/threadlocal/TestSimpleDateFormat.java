package com.hello.javaee.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat();
        df.format(new Date());
    }
}
