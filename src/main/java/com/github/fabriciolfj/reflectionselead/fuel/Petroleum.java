package com.github.fabriciolfj.reflectionselead.fuel;

public sealed class Petroleum implements LiquidFuel permits Diesel, Gasoline, Ethanol {}