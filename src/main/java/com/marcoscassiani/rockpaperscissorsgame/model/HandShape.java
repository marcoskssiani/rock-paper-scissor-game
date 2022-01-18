package com.marcoscassiani.rockpaperscissorsgame.model;

public enum HandShape {

    ROCK    ( 0),
    PAPER   ( 1),
    SCISSOR ( 2);

    private int code;

    HandShape(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}