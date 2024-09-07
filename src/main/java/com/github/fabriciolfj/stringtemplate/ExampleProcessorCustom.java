package com.github.fabriciolfj.stringtemplate;

public class ExampleProcessorCustom {

    public static void main(String[] args) {
        String phone = "072-825-9009";
        var pp = new PhoneProcessor();
        var world = pp."""
            meu fone : "\{phone}"
            """;

        System.out.println(world);
    }
}
