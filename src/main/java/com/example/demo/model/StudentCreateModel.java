package com.example.demo.model;

public class StudentCreateModel {
    private String studentName;
    private String studentAddress;
    private int studentScore;

    public StudentCreateModel(String studentName, String studentAddress, int studentScore) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentScore = studentScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }
}
