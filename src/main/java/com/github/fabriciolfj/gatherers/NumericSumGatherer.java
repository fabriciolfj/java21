package com.github.fabriciolfj.gatherers;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

//muitos pra 1
public class NumericSumGatherer implements Gatherer<Integer, ArrayList<Integer>, Integer> {

    @Override
    public Supplier<ArrayList<Integer>> initializer() {
        return ArrayList::new;
    }

    @Override
    public Integrator<ArrayList<Integer>, Integer, Integer> integrator() {
        return (state, element, downstream) -> {
            if (state.isEmpty()) {
                state.add(element);
            } else {
                state.addFirst(state.getFirst() + element);
            }
            return true;
        };
    }

    @Override
    public BiConsumer<ArrayList<Integer>, Downstream<? super Integer>> finisher() {
        return (state, downstream) -> {
            if (!downstream.isRejecting() && !state.isEmpty()) {
                downstream.push(state.getFirst());
                state.clear();
            }
        };
    }
}