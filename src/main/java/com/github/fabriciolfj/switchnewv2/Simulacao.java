package com.github.fabriciolfj.switchnewv2;

public class Simulacao {

    public static void main(String[] args) {
        var player = PlayerType.FOOTBALL;

        check(player);
    }

    private static void check(final Player player) {
        switch (player) {
            case PlayerType.TENNIS ->  System.out.println("tenis");
            case PlayerType.SNOOKER ->  System.out.println("snooker");
            case PlayerType.FOOTBALL ->  System.out.println("football");
            case Golf golf ->  System.out.println("golf");
            default -> throw new IllegalStateException("Unexpected value: " + player);
        }
    }
}
