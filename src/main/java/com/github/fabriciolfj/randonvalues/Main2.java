package com.github.fabriciolfj.randonvalues;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class Main2 {

    public static void main(String[] args) {
        RandomGenerator.StreamableGenerator streamableRnd
                = RandomGenerator.StreamableGenerator.of("L128X1024MixRandom");

        List<int[]> listOfArrOfIntsSG
                = streamableRnd.rngs(5) // get 5 pseudo-random generators
                .map(r -> r.ints(10))  // generate 10 ints per generator
                .map(IntStream::toArray)
                .toList();
    }
}
