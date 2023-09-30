package com.github.fabriciolfj;

import static java.lang.StringTemplate.STR;

public class StringModeloVisualizacaoTest {

    public static void main(String[] args) {
        var teste = "fabricio";
        String message = STR."greetings \{teste}!";

        System.out.println(message);
    }
}
