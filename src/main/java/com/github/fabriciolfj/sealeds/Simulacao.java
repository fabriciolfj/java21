package com.github.fabriciolfj.sealeds;

import java.util.Arrays;
import java.util.List;

public class Simulacao {

    public static void main(String[] args) {
        List<Integer> produtos = Arrays.asList(1, 2, 3);
        ShoppingCart carrinho = new ShoppingCart.Pending(produtos);

        if (carrinho instanceof ShoppingCart.Pending) {
            var carrinhoPendente = (ShoppingCart.Pending) carrinho;
            if (carrinhoPendente.isEmpty()) {
                System.out.println("O carrinho está vazio.");
            } else {
                System.out.println("O carrinho contém produtos: " + carrinhoPendente.products());
            }
        }
    }
}
