package com.github.fabriciolfj;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;

public class GetFirstAndLastDayQuarter {

    public static void main(String[] args) {
        var localDate = LocalDate.of(2024, 5, 1);

        LocalDate firstDaty = localDate.with(IsoFields.DAY_OF_QUARTER, 1L);
        LocalDate lastDay = firstDaty.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(firstDaty);
        System.out.println(lastDay);
    }
}
