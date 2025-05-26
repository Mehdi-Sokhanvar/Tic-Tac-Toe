package com.basic.model;

public enum Symbol {
    X('X'),
    O('O'),
    EMPTY(' ');
    private final char symbol;

    private Symbol(char symbol) {
        this.symbol = symbol;
    }


    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
