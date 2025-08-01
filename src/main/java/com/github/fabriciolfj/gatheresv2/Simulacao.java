package com.github.fabriciolfj.gatheresv2;

import java.util.stream.Gatherer;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class Simulacao {

    public static void main(String[] args) {
        var result = Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.fold(() -> 0, Integer::sum))
                .findFirst()
                .orElseGet(() -> 0);

        System.out.println(result);

        Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5, 6)
                .gather(Gatherers.windowSliding(3))
                .forEach(System.out::println);

        Stream.of(10, 20, 30, 40, 50)
                .gather(Gatherers.windowSliding(3))
                .map(window -> window.stream().mapToInt(Integer::intValue).average().orElse(0))
                .forEach(media -> System.out.println("Média: " + media));


    }
}
