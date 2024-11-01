package com.github.fabriciolfj.swithwithnull;

public class Simulacao {

    public static void main(String[] args) {
        var estado = EstadoEnum.MG;

        var result = switch(estado) {
            case MG -> "caro";
            case SP, RJ -> "barato";
            case null, default -> new IllegalArgumentException();
        };

        System.out.println(result);
    }
}
