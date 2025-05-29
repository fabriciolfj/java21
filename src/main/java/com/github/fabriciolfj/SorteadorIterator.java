package com.github.fabriciolfj;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class SorteadorIterator implements Iterator<Integer> {

    private static final Random RANDOM = new Random();
    private int current = 0;

    @Override
    public boolean hasNext() {
        return current < 6;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("not element");
        }

        current++;
        return RANDOM.nextInt(60);
    }
}
