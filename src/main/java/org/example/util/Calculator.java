package org.example.util;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final List<Operation> ALL_OPERATIONS = Arrays.asList(Operation.values());
    public static String calculation(String exampleStr){
        StringBuilder example = new StringBuilder(exampleStr);
        try {
            Double leftNumber = null, rightNumber = null;
            Operation executionOperation= null;
            for(int i = 0; i < example.length(); i++){
                for(Operation operation: ALL_OPERATIONS){
                    if(example.charAt(i) == operation.getOperationChar()){
                        executionOperation = operation;
                        leftNumber = Double.parseDouble(example.substring(0, i));
                        rightNumber = Double.parseDouble(example.substring(i+1,example.length()));
                    }
                }
            }
            return getAnswer(leftNumber, rightNumber, executionOperation);
        }catch (Exception ex){
            return "ERROR";
        }
    }

    private static String getAnswer(Double leftNumber, Double rightNumber, Operation executionOperation){
        switch (executionOperation){
            case PLUS -> {
                return String.valueOf(leftNumber + rightNumber);
            }
            case MINUS -> {
                return String.valueOf(leftNumber - rightNumber);
            }
            case MULTIPLY -> {
                return String.valueOf(leftNumber * rightNumber);
            }
            case DIVISION -> {
                return String.valueOf(leftNumber / rightNumber);
            }
            default -> {
                return "ERROR";
            }
        }
    }
}
