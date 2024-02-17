package com.github.fabriciolfj.generics;

public class ContainerTypeFromParameter<T> {

    private T clazz;

    public ContainerTypeFromParameter(T clazz) {
        this.clazz = clazz;
    }

    public T getClazz() {
        return clazz;
    }
}
