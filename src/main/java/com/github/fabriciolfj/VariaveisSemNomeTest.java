package com.github.fabriciolfj;

import static java.lang.StringTemplate.STR;

public class VariaveisSemNomeTest {

    public static void main(String[] args) {
        String value = "3";
        try {
            var result = Integer.parseInt(value);
            System.out.println(STR."valor convertido \{result}");
        } catch (Exception _) {
            System.out.println(STR."problema na conversao do valor \{value}");
        }
    }
}
