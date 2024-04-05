package com.github.fabriciolfj.jep456;

public non-sealed class RedBall extends Ball {

    public RedBall(String describe) {
        super(describe);
    }

    @Override
    public String getCustomDescribe() {
        return STR."\{this.describe} ball red";
    }
}
