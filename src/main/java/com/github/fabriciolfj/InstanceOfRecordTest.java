package com.github.fabriciolfj;

import com.github.fabriciolfj.pojo.Point;

public class InstanceOfRecordTest {

    public static void main(String[] args) {
        var point = new Point(2, 3);

        if (point instanceof Point(int x, int y)) {
            System.out.println("value x=" + x);
            System.out.println("value y=" + y);
        }
    }
}
