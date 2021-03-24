package com.example.demo.studentException;

public class StudentException extends Exception {
    private int code = 500;

    public StudentException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
