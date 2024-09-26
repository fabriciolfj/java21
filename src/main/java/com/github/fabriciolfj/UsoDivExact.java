package com.github.fabriciolfj;

import java.util.function.BinaryOperator;

public class UsoDivExact {

    //para nao dar um valor incorreto, e lancada uma arithmeticexception
    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;

        BinaryOperator<Integer> operator = Math::floorDivExact;

        int result = operator.apply(x, -1);

        System.out.println(result);
    }
}
