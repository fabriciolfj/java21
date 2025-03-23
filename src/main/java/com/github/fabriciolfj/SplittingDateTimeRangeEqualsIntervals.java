package com.github.fabriciolfj;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SplittingDateTimeRangeEqualsIntervals {

    public static void main(String[] args) {
        var start = LocalDateTime.now().minusHours(2);
        var end = LocalDateTime.now();
        var parts = 4;

        Duration range = Duration.between(start, end);
        System.out.println(STR."range \{range}");

        Duration interval = range.dividedBy(parts - 1);
        System.out.println(STR."interval \{interval}");
        var listOfDates = new ArrayList<LocalDateTime>();

        LocalDateTime timeLine = start;
        for (int i = 0; i < parts -1; i ++) {
            listOfDates.add(timeLine);
            timeLine = timeLine.plus(interval);
        }

        listOfDates.add(end);
        System.out.println(listOfDates);
    }
}
