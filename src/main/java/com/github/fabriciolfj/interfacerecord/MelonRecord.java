package com.github.fabriciolfj.interfacerecord;

public record MelonRecord(String type, float weight) implements PestInspector{

    @Override
    public void exterminatePest() {
        if (detectPest()) {
            System.out.println(STR."all pest been exterminated");
            return;
        }

        System.out.println("this melon is clean, no pests have been found");

    }
}
