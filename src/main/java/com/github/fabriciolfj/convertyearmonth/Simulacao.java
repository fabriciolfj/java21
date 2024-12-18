package com.github.fabriciolfj.convertyearmonth;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class Simulacao {

    public static void main(String[] args) {
        var result = YearMonth.from(LocalDate.now());

        System.out.println(result);

        Date date = new Date();
        result = YearMonth.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        System.out.println(result);
    }
}
