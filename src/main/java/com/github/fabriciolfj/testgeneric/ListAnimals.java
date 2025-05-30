package com.github.fabriciolfj.testgeneric;

import java.util.ArrayList;
import java.util.List;

public class ListAnimals<T extends Animal> {

    private List<T> animals = new ArrayList<>();

    public void add(T animal) {
        this.animals.add(animal);
    }

    public List<T> getAnimals() {
        return this.animals;
    }

}
