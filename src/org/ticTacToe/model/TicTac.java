package org.ticTacToe.model;

public enum TicTac {
    TIC("X"),
    TAC("Y"),
    EMPTY(".");

    public String getMark() {
        return mark;
    }

    TicTac(String mark) {
        this.mark = mark;
    }

    private String mark;
}
