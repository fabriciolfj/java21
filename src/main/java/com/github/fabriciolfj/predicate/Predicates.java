package com.github.fabriciolfj.predicate;

import java.util.function.Predicate;
import java.util.stream.Stream;

public final class Predicates {

    private Predicates() {
        throw new AssertionError("cannot be instantiated");
    }

    public static <T> Predicate<T> asOneAnd(Predicate<T>... predicates) {
        Predicate<T> theOneAnd = Stream.of(predicates).reduce(p -> true, Predicate::and);

        return theOneAnd;
    }

    public static <T> Predicate<T> asOneOr(Predicate<T>... predicates) {

        Predicate<T> theOneOr = Stream.of(predicates).reduce(p -> false, Predicate::or);

        return theOneOr;
    }
}
