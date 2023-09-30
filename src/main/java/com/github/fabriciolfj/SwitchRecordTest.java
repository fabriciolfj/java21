package com.github.fabriciolfj;

import com.github.fabriciolfj.pojo.Point;

public class SwitchRecordTest {

    public static void main(String[] args) {
        var t = new SwitchRecordTest();
        t.print(new Point(1, 4));
    }

    public void print(Object o) {
        switch (o) {
            case Point(int x, int y) 		-> System.out.printf("o is a position: %d/%d%n", x, y);
            case String s               -> System.out.printf("o is a string: %s%n", s);
            default                     -> System.out.printf("o is something else: %s%n", o);
        }
    }
}
