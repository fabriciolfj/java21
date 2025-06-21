package com.github.fabriciolfj.gatherers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

//muitos pra muitos
public class SlidingWindowGatherer implements Gatherer<Integer, ArrayList<Integer>, List<Integer>> {

    @Override
    public Supplier<ArrayList<Integer>> initializer() {
        return ArrayList::new;
    }

    @Override
    public Integrator<ArrayList<Integer>, Integer, List<Integer>> integrator() {
        return (state, element, downstream) -> {
            state.add(element);
            if (state.size() == 3) {
                downstream.push(new ArrayList<>(state));
                state.removeFirst();
            }
            return true;
        };
    }

    @Override
    public BiConsumer<ArrayList<Integer>, Downstream<? super List<Integer>>> finisher() {
        return (state, downstream) -> {
            if (state.size()==3) {
                downstream.push(new ArrayList<>(state));
            }
        };

    }
}