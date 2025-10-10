package com.github.fabriciolfj.permitstest;

public sealed class Petroleum implements LiquidFuel permits Diesel, Gasoline, Ethanol {}