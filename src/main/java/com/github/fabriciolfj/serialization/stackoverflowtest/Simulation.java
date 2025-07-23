package com.github.fabriciolfj.serialization.stackoverflowtest;

import com.github.fabriciolfj.serialization.filter.Converters;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Simulation {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<Set, Integer> mapOfSets = new HashMap<>();
        var set = new HashSet<Set>();
        mapOfSets.put(set, 1);

        set.add(set);

        var filter = ObjectInputFilter.Config.createFilter("maxdepth=2;java.base/*;!*");
        byte[] mapSer = Converters.objectToBytes(mapOfSets);

        var objet = (HashMap) Converters.bytesToObject(mapSer, filter);

        System.out.println(objet);
    }
}
