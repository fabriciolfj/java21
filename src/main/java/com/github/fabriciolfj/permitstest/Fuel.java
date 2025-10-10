package com.github.fabriciolfj.permitstest;

public sealed interface Fuel permits SolidFuel, LiquidFuel, GaseousFuel {}