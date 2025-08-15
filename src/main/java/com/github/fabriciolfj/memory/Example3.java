package com.github.fabriciolfj.memory;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class Example3 {

    public static void main(String[] args) {
        var area = Arena.ofAuto();
        MemorySegment segment = area.allocate(ValueLayout.JAVA_INT, 1000);

        System.out.println(segment.address());

        MemorySegment addr = segment.getAtIndex(ValueLayout.ADDRESS, 1);

        System.out.println(addr);
    }
}
