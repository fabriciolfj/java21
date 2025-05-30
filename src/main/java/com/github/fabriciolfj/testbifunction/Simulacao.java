package com.github.fabriciolfj.testbifunction;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class Simulacao {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> bifunction = (a, b) -> STR."total: (\{a} + \{b})";

        var result = bifunction.apply(9, 3);
        System.out.println(result);
    }
}
