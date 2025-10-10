package com.github.fabriciolfj.permitstest;

public sealed interface SolidFuel extends Fuel permits Coke, Charcoal {}