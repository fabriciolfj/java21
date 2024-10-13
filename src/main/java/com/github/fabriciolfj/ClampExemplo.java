package com.github.fabriciolfj;

public class ClampExemplo {

    private static final int MIN_PRESSURE = 10;
    private static final int MAX_PRESSURE = 50;

    public static void main(String[] args) {
        var result = Math.clamp(11, MIN_PRESSURE, MAX_PRESSURE);

        System.out.println(result);

        result = Math.clamp(9, MIN_PRESSURE, MAX_PRESSURE);

        System.out.println(result);
    }
}
