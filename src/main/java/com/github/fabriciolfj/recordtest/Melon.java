package com.github.fabriciolfj.recordtest;

public record Melon(String type, float weight) {

    public Melon {
        if (type == null) {
            throw new IllegalArgumentException("the melon`s type cannot be null");
        }

        if (weight < 1000 || weight > 10000) {
            throw new IllegalArgumentException("the melon`s weight must be between 1000 an 10000 grams");
        }

        weight = weight / 1_000;
    }
}
