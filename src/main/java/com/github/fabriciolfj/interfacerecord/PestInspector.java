package com.github.fabriciolfj.interfacerecord;

public interface PestInspector {

    default boolean detectPest() {
        return Math.random() > 0.5d;
    }

    void exterminatePest();
}
