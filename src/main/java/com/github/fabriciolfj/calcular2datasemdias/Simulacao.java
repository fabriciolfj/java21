package com.github.fabriciolfj.calcular2datasemdias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Simulacao {

    private static final int PREGNANCY_WEEKS = 40;
    private static final int PREGNANCY_DAYS = PREGNANCY_WEEKS * 7;

    public static void main(String[] args) {
        final var firstday = LocalDate.now().minusDays(15);
        final var endDay = firstday.plusDays(PREGNANCY_DAYS);
        System.out.println(STR."Due date  \{firstday}");

        final var betweenDays = Math.abs(ChronoUnit.DAYS.between(endDay, LocalDate.now()));

        System.out.println(betweenDays);
    }
}
