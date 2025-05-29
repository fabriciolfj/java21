package com.github.fabriciolfj;

public class SorteadorMain {

    public static void main(String[] args) {
        var sorteador = new SorteadorIterable();
        var iterator = sorteador.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
