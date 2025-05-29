package com.github.fabriciolfj;

import java.util.Iterator;

public class SorteadorIterable implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new SorteadorIterator();
    }
}
