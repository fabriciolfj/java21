package com.github.fabriciolfj.supplierconsumer;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    static void main() {
        Supplier<Integer> supplier = () -> Counter.count();
        Consumer<Integer> consumer = c -> {
            c = c + Counter.count();
            System.out.println("Consumer: " + c);
        };

        consumer.accept(Counter.c);
        consumer.accept(Counter.c);
        System.out.println("Counter " + Counter.c);

        System.out.println("supplier: " + supplier.get());
    }
}
