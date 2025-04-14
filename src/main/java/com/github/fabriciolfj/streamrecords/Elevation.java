package com.github.fabriciolfj.streamrecords;

public record Elevation(double value) {

    public Elevation(double value) {
        this.value = value * 0.393701;
    }
}
