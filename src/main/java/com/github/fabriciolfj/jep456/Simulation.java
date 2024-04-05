package com.github.fabriciolfj.jep456;

public class Simulation {

    public static void main(String[] args) {
        var ball = new BlueBall("futebol");
        extracted(ball);
    }

    private static void extracted(Ball ball) {
        switch (ball) {
            case RedBall _ -> System.out.println(STR."red \{ball.getCustomDescribe()}");
            case BlueBall _ -> System.out.println(STR."blue \{ball.getCustomDescribe()}");
        }
    }
}
