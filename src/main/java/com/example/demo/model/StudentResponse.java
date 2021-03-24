package com.example.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentResponse{
    @Expose
    @SerializedName("student_id")
    private int studentId;
    @Expose
    @SerializedName("student_name")
    private String studentName;
    @Expose
    @SerializedName("student_address")
    private String studentAddress;
    @Expose
    @SerializedName("student_score")
    private int studentScore;
    public StudentResponse() {
    }

    public StudentResponse(int studentId, String studentName, String studentAddress, int studentScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentScore = studentScore;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
