package com.github.fabriciolfj.morerecord;

public record Resident(String name, Doctor doctor) implements Staff {
}
