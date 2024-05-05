package com.github.fabriciolfj.gatherexemple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

public class Exemplo {

    static <T, A> Gatherer<T, ?, T> distinctBy(Function<? super T, ? extends A> classifier) {
        Supplier<Map<A, List<T>>> initializer = HashMap::new;
        Gatherer.Integrator<Map<A, List<T>>, T, T> integrator = (state, element, _) -> {
            state.computeIfAbsent(classifier.apply(element), _ -> new ArrayList<>()).add(element);
            return true; // true, because more elements need to be consumed
        };
        BiConsumer<Map<A, List<T>>, Gatherer.Downstream<? super T>> finisher = (state, downstream) -> {
            state.forEach((_, value) -> downstream.push(value.getLast()));
        };
        return Gatherer.ofSequential(initializer, integrator, finisher);
    }

    //uso
    /*
    guitars.stream()
        .gather(distinctBy(Guitar::guitarStyle))
        .forEach(System.out::println);
     */
}
