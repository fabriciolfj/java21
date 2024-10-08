package com.github.fabriciolfj.arredondamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Simulacao {

    public static void main(String[] args) {
        float v = 14.9877655f;
        int d = 5;

        var bd = new BigDecimal(Float.toString(v));
        bd = bd.setScale(d, RoundingMode.HALF_UP);

        System.out.println(bd);
    }
}
