package com.github.fabriciolfj.testgeneric;

import java.util.function.Function;

public class Simulacao {

    public static void main(String[] args) {
        var animal = new Animal("test");
        var dog = new Dog("dog");
        var mammal = new Mammal("mammal");
        var cat = new Cat("cat");

        var list = new ListAnimals<Animal>();
        list.add(animal);
        list.add(dog);
        list.add(mammal);
        list.add(cat);

        Function<Dog, String> function = v -> STR."animal \{v.getName()}";
        list.getAnimals().forEach(v -> {
            if (v  instanceof Dog) {
                var result = convertToString(function, (Dog) v);
                System.out.println(result);
            }
        });
    }

    /*private static <T extends Dog, R> R convertToString(T value) {
        return (R) value.getName().toString();
    }*/

    private static <R> R convertToString(Function<? super Dog, R> converter, Dog value) {
        return converter.apply(value);
    }

}
