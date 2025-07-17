package com.github.fabriciolfj.serialization.filter;

import com.github.fabriciolfj.serialization.Melon;

import java.io.IOException;
import java.io.ObjectInputFilter;

public class Simulation {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var melon = new Melon("teste", 2);

        //ObjectInputFilter melonFitler = ObjectInputFilter.Config.createFilter("!com.github.fabriciolfj.serialization.Melon;");

        ObjectInputFilter.Config.setSerialFilter(new MelonFilter());

        var result = Converters.objectToBytes(melon);

        var melonDeserialize = (Melon) Converters.bytesToObject(result, ObjectInputFilter.Config.getSerialFilter());

        System.out.println(STR."object \{melonDeserialize}");

    }
}
