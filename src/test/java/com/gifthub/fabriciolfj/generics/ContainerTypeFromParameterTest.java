package com.gifthub.fabriciolfj.generics;

import com.github.fabriciolfj.generics.ContainerTypeFromParameter;
import com.github.fabriciolfj.generics.ContainerTypeFromReflection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerTypeFromParameterTest {

    @Test
    void testContainerTypeFromParameter() {
        var container = new ContainerTypeFromParameter<>(String.class);

        assertEquals(container.getClazz(), String.class);
    }

    @Test
    void testContainerTypeFromReflection() {
        var container = new ContainerTypeFromReflection<>(1);

        assertEquals(container.getClazz(), Integer.class);
    }
}
