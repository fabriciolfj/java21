package com.github.fabriciolfj.sealeds;

import java.util.ArrayList;
import java.util.List;

public sealed interface ShoppingCart {

    record Initial() implements ShoppingCart {

    }

    record Pending(List<Integer> products) implements ShoppingCart {
        public boolean isEmpty() {
            return products.isEmpty();
        }
    }

    record Closed() implements ShoppingCart {
    }
    
    static ShoppingCart state(ShoppingCart state, String value) {
        return switch (state) {
            case Initial initial -> new Pending(new ArrayList<>());
            case Pending pending -> new Closed();
            default -> throw new IllegalStateException("Unexpected value: " + state);
        };
    }
}
