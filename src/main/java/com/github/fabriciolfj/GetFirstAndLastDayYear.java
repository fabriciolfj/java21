package com.github.fabriciolfj;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetFirstAndLastDayYear {

    public static void main(String[] args) {
        final var ld = LocalDate.ofYearDay(2020, 1);
        final var formt = DateTimeFormatter.ofPattern("EEEE");
        System.out.println(formt.format(ld));

        final var last = LocalDate.ofYearDay(2020, 31);
        System.out.println(formt.format(last));
    }
}
