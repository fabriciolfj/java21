package com.github.fabriciolfj.sequence;

import java.util.LinkedHashMap;

public class SequenceLinkedHashMap {

    public static void main(String[] args) {
        var linked = new LinkedHashMap<Integer, String>();
        linked.put(1, "one");
        linked.put(2, "two");
        linked.put(3, "three");
        linked.put(4, "four");
        linked.put(5, "five");

        System.out.println(linked.firstEntry());
        System.out.println(linked.lastEntry());

        linked.putFirst(0, "zero");
        linked.putLast(6, "six");

        System.out.println(linked.firstEntry());
        System.out.println(linked.lastEntry());

        //apagar o primeiro  eo ultimo
        linked.pollFirstEntry();
        linked.pollLastEntry();

        System.out.println(linked.firstEntry());
        System.out.println(linked.lastEntry());

        System.out.println("==========");

        System.out.println(linked.firstEntry());
        System.out.println(linked.lastEntry());

        var setTest = linked.sequencedKeySet();

        System.out.println(setTest.getFirst());
        System.out.println(setTest.getLast());

        var valueTest = linked.sequencedEntrySet();

        System.out.println(valueTest.getFirst());
        System.out.println(valueTest.getLast());

    }
}
