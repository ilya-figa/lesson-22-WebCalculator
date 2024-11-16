package org.example.util;

public enum Operation {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVISION('/');

    private char operationChar;
    Operation(char operationChar){
        this.operationChar = operationChar;
    }

    public char getOperationChar() {
        return operationChar;
    }
}
