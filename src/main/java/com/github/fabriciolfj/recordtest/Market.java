package com.github.fabriciolfj.recordtest;

import java.util.Map;

public record Market(Map<String, Integer> retails) {

    public Market {
        retails = Map.copyOf(retails);
    }
}
