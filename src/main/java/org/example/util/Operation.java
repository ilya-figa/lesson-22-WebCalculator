package org.example.util;

public enum Operation {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVISION('/');

    private char operChar;
    Operation(char operChar){
        this.operChar = operChar;
    }

    public char getOperChar() {
        return operChar;
    }
}
