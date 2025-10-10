package com.github.fabriciolfj.permitstest;

public sealed interface GaseousFuel extends Fuel permits NaturalGas, Propane {}
