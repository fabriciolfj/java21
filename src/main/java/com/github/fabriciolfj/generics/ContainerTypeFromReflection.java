package com.github.fabriciolfj.generics;

public class ContainerTypeFromReflection<T> {

    private T clazz;

    public ContainerTypeFromReflection(T clazz) {
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz.getClass();
    }
}
