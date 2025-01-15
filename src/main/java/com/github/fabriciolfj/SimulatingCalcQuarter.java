package com.github.fabriciolfj;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.IsoFields;
import java.util.Date;

public class SimulatingCalcQuarter {


    public static void main(String[] args) {
        String[] quartes = {"Q1", "Q2", "Q3", "Q4"};
        var date = new Date(2025, 5, 1);
        var result = quarter(date);
        System.out.println(quartes[result-1]);
    }

    private static int quarter(Date date) {
        final LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        return localDate.get(IsoFields.QUARTER_OF_YEAR);
    }
}
