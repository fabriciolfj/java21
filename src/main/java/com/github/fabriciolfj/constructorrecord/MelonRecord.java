package com.github.fabriciolfj.constructorrecord;

import java.util.HashSet;
import java.util.Set;

public record MelonRecord(String type, float weight) {

    private static final String DEFAULT_MELON_TYPE = "Crenshaw";
    private static final float DEFAULT_MELON_WEIGHT = 1000;
    private static Set<String> countries = new HashSet<>();

    MelonRecord() {
        this(DEFAULT_MELON_TYPE, DEFAULT_MELON_WEIGHT);
    }

    MelonRecord(String type) {
        this(type, DEFAULT_MELON_WEIGHT);
    }

    MelonRecord(float weight) {
        this(DEFAULT_MELON_TYPE, weight);
    }

    MelonRecord(String type, float weight, String country) {
        this(type, weight);
        MelonRecord.countries.add(country);
    }
}
