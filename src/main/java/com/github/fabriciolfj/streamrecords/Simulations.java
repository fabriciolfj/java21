package com.github.fabriciolfj.streamrecords;

import com.github.fabriciolfj.recordtest.Melon;
import com.github.fabriciolfj.reflectionrecord.MelonRecord;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Simulations {

    public static void main(String[] args) {
        var melons = Arrays.asList(
                new MelonRecord("crenshaw", 1200),
                new MelonRecord("gac", 3000),
                new MelonRecord("hemi", 2600)
        );

            var total = melons.stream()
                    .collect(Collectors.teeing(
                            Collectors.summingDouble(MelonRecord::weight),
                            Collectors.mapping(MelonRecord::weight, Collectors.toList())
                            , WeightsAndTotalRecord::new));

            System.out.println(total);

            var elevations = DoubleStream.of(22, -10, 100, -5, 100, 123, 22, 230, -1 , 250, 22)
                    .filter(e -> e > 0)
                    .mapToObj(Elevation::new)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(
                            Collectors.counting(),
                            ElevationCount::new
                    )));

        System.out.println(elevations);
    }
}
