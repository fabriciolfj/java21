package com.github.fabriciolfj.jep456;

public sealed abstract class Ball permits BlueBall, RedBall {

    protected String describe;

    public Ball(final String describe) {
        this.describe = describe;
    }

    public abstract String getCustomDescribe();
}
