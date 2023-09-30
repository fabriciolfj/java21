package com.github.fabriciolfj;

import java.util.UUID;

/*
public class ScopedValuesTest {

    public static void main(String[] args) {
        String loggedInUser = LoginUtil.LOGGED_IN_USER.get();
    }
}

class LoginUtil {
    public final static ScopedValue<String> LOGGED_IN_USER = ScopedValue.newInstance();

    String loggedUser = getUser();
    //where vincula o escopo a instancia do objeto
    ScopedValue.where(LOGGED_IN_USER, loggedUser).run(() -> service.getData());

    private String getUser() {
        return UUID.randomUUID().toString();
    }
}*/
