package com.github.fabriciolfj.permitstest;

public sealed class Methane implements NaturalGas permits Chloromethane, Dichloromethane {}