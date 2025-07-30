package com.github.fabriciolfj.memory;

import java.awt.geom.Area;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class Example2 {

    public static void main(String[] args) {
        Arena arena = Arena.ofAuto();
        MemorySegment segment = arena.allocateFrom(("abc"));

        var val = segment.getString(0);
        System.out.println(val);
    }
}
