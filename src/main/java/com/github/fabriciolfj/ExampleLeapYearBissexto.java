package com.github.fabriciolfj;

import java.time.Year;

public class ExampleLeapYearBissexto {

    public static void main(String[] args) {
        System.out.println(isLeapYear(2024));
    }

    private static boolean isLeapYear(int year) {
        return Year.of(year).isLeap();
    }
}
