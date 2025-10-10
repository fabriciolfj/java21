package com.github.fabriciolfj.permitstest;

public sealed interface NaturalGas extends GaseousFuel permits Hydrogen, Methane {}
