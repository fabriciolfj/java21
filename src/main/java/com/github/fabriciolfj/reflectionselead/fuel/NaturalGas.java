package com.github.fabriciolfj.reflectionselead.fuel;

public sealed interface NaturalGas extends GaseousFuel permits Hydrogen, Methane {}
