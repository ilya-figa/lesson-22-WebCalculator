package org.example.util;

public class Response {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result='" + result + '\'' +
                '}';
    }
}
