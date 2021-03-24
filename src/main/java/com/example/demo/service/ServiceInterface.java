package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentCreateModel;
import com.example.demo.response.ResponseMessage;
import com.example.demo.studentException.StudentException;

import java.util.List;

public interface ServiceInterface {
    public ResponseMessage findById(int id) throws StudentException;
    public ResponseMessage insert(StudentCreateModel s) throws StudentException;
    public ResponseMessage deleteById(int id) throws StudentException;
    public ResponseMessage update(int id, StudentCreateModel s) throws StudentException;
    public ResponseMessage getTopScore(int top) throws StudentException;
}
