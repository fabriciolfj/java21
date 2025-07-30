package com.github.fabriciolfj.memory;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class Example1 {

    public static void main(String[] args) {
        Arena arena = Arena.ofAuto();
        //MemorySegment segment = arena.allocate(4,4);
        MemorySegment segment = arena.allocate(ValueLayout.JAVA_INT.byteSize(), ValueLayout.JAVA_INT.byteAlignment());
        segment.setAtIndex(ValueLayout.JAVA_INT, 0, Integer.MAX_VALUE);

        int val = segment.get(ValueLayout.JAVA_INT, 0);
        int val2 = segment.getAtIndex(ValueLayout.JAVA_INT, 0);


    }
}
