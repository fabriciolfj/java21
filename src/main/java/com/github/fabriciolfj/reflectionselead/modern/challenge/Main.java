package com.github.fabriciolfj.reflectionselead.modern.challenge;

import com.github.fabriciolfj.reflectionselead.fuel.Coke;
import com.github.fabriciolfj.reflectionselead.modern.reflection.Inspector;

import com.github.fabriciolfj.reflectionselead.fuel.Fuel;
import com.github.fabriciolfj.reflectionselead.fuel.Methane;
import com.github.fabriciolfj.reflectionselead.fuel.SolidFuel;

public class Main {

    public static void main(String[] args) {
        
        Coke coke = new Coke();
        Methane methane = new Methane();
                
        System.out.println("Fuel subclasses: " + Inspector.permittedClasses(Fuel.class));
        System.out.println("SolidFuel subclasses: " + Inspector.permittedClasses(SolidFuel.class));
        System.out.println("Coke subclasses: " + Inspector.permittedClasses(coke.getClass()));
        System.out.println("Methane subclasses: " + Inspector.permittedClasses(methane.getClass()));        
    }
}