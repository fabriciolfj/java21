package com.github.fabriciolfj.listfactories;

import java.util.List;
import java.util.stream.Stream;

public class Simulacao {

    public static void main(String[] args) {
        var dados = Stream.of("teste", "test2").toList();

        System.out.println(dados);
    }
}
