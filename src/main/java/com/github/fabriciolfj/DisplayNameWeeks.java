package com.github.fabriciolfj;

import java.text.DateFormatSymbols;
import java.util.stream.IntStream;

public class DisplayNameWeeks {

    public static void main(String[] args) {
        final String[] weekdays = new DateFormatSymbols().getWeekdays();

        IntStream.range(1, weekdays.length)
                .mapToObj(t -> String.format("Day: %d -> %s", t, weekdays[t]))
                .forEach(System.out::println);
    }
}
