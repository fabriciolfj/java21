package com.github.fabriciolfj.java131;

import java.io.IOException;

public class Simulation {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var melon = new Melon("test", 10);

        byte[] melonSer = Melon.objectToBytes(melon);

        final Melon melonDeser = (Melon) Melon.bytesToObject(melonSer);

        System.out.println(melonDeser);
    }
}
