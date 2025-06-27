package com.github.fabriciolfj.gatherers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

//um pra muitos
public class SentenceSplitterGatherer implements Gatherer<String, List<String>,String> {

    @Override
    public Supplier<List<String>> initializer() {
        return ArrayList::new;
    }


    @Override
    public Integrator<List<String>, String, String> integrator() {
        return (state, element, downstream) -> {
            var words = element.split("\\s+");
            for (var word : words) {
                state.add(word);
                downstream.push(word);
            }
            return true;
        };
    }
}