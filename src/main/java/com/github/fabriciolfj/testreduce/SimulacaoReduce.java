package com.github.fabriciolfj.testreduce;

import java.util.List;
import java.util.function.BinaryOperator;

public class SimulacaoReduce {

    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6);

        final BinaryOperator<Integer> operator = Integer::sum;

        var result = numbers.stream().reduce(operator);

        System.out.println(result);
    }
}
