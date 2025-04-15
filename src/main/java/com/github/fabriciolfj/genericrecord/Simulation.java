package com.github.fabriciolfj.genericrecord;

public class Simulation {

    public static void main(String[] args) {
        final FruitRecord<MelonRecord> fruit = new FruitRecord<>(new MelonRecord("hami",  100), "China");

        if (fruit instanceof FruitRecord<MelonRecord>(var melon, var country)) {
            System.out.println(STR."\{melon.type()} and country \{country}");
        }
    }
}
