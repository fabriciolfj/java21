package com.github.fabriciolfj.factorymaps;

import java.util.HashMap;
import java.util.Map;

public class Simulacao {

    public static void main(String[] args) {
        final Map<Integer, String> map = Map.of(1 , "test", 2, "test 2");
        var imap = Map.copyOf(map);

        System.out.println(imap == map);
    }
}
