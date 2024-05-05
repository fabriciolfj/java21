package com.github.fabriciolfj;

import com.github.fabriciolfj.pojo.Person;

import java.util.UUID;
import java.util.concurrent.StructuredTaskScope;
/*

public class ScopedValuesTest {

    private static final ScopedValue<Integer> drinkOrderId = ScopedValue.newInstance();

    public static void main(String[] args) {
        String loggedInUser = LoginUtil.LOGGED_IN_USER.get();
    }

    public Person determineDrinkOrder(Person guest) throws Exception {
        Person zoe = new Person("Zoe", 0);
        Person elmo = new Person("Elmo", 0);
        return ScopedValue.where(drinkOrderId, 1)
                .call(() -> {
                    try (var scope = new StructuredTaskScope.ShutdownOnSuccess<DrinkOrder>()) {
                        scope.fork(() -> zoe.getDrinkOrder(guest, BEER, WINE, JUICE));
                        scope.fork(() -> elmo.getDrinkOrder(guest, COFFEE, TEA, COCKTAIL, DISTILLED));
                        return scope.join().result();
                    }
                });
    }
}

class LoginUtil {
    public final static ScopedValue<String> LOGGED_IN_USER = ScopedValue.newInstance();

    String loggedUser = getUser();
    //where vincula o escopo a instancia do objeto


    private String getUser() {
        ScopedValue.where(LOGGED_IN_USER, loggedUser).run(() -> service.getData());
        return UUID.randomUUID().toString();
    }
}
*/

