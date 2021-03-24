package com.example.demo.model;
public class StudentValidatorImpl implements StudentValidator{
    @Override
    public boolean isValid(Student s) {
        if (!s.getStudentName().isEmpty() &&
                !s.getStudentAddress().isEmpty() &&
                s.getStudentId() >= 0 &&
                s.getStudentScore() >= 0 &&
                s.getStudentScore() <= 10
        ) {
            return true;
        }
        return false;
    }

    public boolean isValid(StudentCreateModel scm){
        if (!scm.getStudentName().isEmpty() &&
                !scm.getStudentAddress().isEmpty() &&
                scm.getStudentScore() >= 0 &&
                scm.getStudentScore() <= 10
        ) {
            return true;
        }
        return false;
    }

}
