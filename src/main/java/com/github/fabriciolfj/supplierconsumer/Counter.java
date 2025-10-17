package com.github.fabriciolfj.supplierconsumer;

public class Counter {

    static int c;
    public static  int count() {
        System.out.println("incrementing c from " + c + "to " + (c + 1));
        return c++;
    }
}
