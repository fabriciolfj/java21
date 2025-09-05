package com.github.fabriciolfj.ball;

import com.github.fabriciolfj.jep456.Ball;

public non-sealed class BlueBall extends Ball {

    public BlueBall(String describe) {
        /*if (describe == null) {
            throw new IllegalArgumentException("description is null")
        }*/
        super(describe);
    }

    @Override
    public String getCustomDescribe() {
        return STR."\{this.describe} ball blue";
    }
}
