package com.github.fabriciolfj.estouroprecisao;

import java.util.function.IntUnaryOperator;

public class Simulacao {

    public static void main(String[] args) {
        var x = Integer.MIN_VALUE;
        IntUnaryOperator operatorInt = Math::absExact; //da um arithmeticexception em vez de um resultado enganoso
        int result = operatorInt.applyAsInt(x);
        System.out.println(result);
    }
}
