package com.github.fabriciolfj.maisoperadoresstream;

import java.util.List;

public class Example {

    static void main() {
        var values = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        var result = values.stream().mapMulti((v, consumer) -> {
            if (v % 2 == 0) {
                consumer.accept(v);
            }
        }).toList();

        System.out.println(result);

        var result2 = values.stream().anyMatch(v -> v % 2 == 0);
        System.out.println(result2);

        var result3 = values.removeIf(v -> v % 2 != 0);
        System.out.println(result3);
        System.out.println(values);
    }
}
