package com.example.demo.service;
import com.example.demo.model.Student;
import com.example.demo.model.StudentCreateModel;
import com.example.demo.model.StudentResponse;
import com.example.demo.model.StudentValidator;
import com.example.demo.repository.StudentRepository;
import com.example.demo.response.ResponseMessage;
import com.example.demo.studentException.StudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements ServiceInterface{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentValidator studentValidator;


    public ResponseMessage findById(int id) throws StudentException {
        if(id < 0 ){
            throw new StudentException("Id not match", 401);
        }
        Student s = studentRepository.findById(id);
        if (s == null) {
            throw new StudentException("Id Not Found", 404);
        }
        StudentResponse sr = new StudentResponse();
        sr.setStudentId(s.getStudentId());
        sr.setStudentName(s.getStudentName());
        sr.setStudentAddress(s.getStudentAddress());
        sr.setStudentScore(s.getStudentScore());
        ResponseMessage res = new ResponseMessage();
        res.setMessage("OK");
        res.setStatus(200);
        res.setData(sr);
        return res;
    }

    public ResponseMessage insert(StudentCreateModel s) throws StudentException {
        if(!studentValidator.isValid(s)){
            throw new StudentException("Parameter Not Suitable",401);
        }
        if (!studentRepository.insert(s)) {
            throw new StudentException("Don't Create",400);
        }
        ResponseMessage res = new ResponseMessage();
        res.setMessage("OK");
        res.setStatus(200);
        return res;
    }

    public ResponseMessage deleteById(int id) throws StudentException {
        if(id < 0 ){
            throw new StudentException("Parameter not match", 401);
        }
        Student s = studentRepository.findById(id);
        if (s == null) {
            throw new StudentException("Id Not Found",404);
        }
        if(!studentRepository.deleteById(id)) {
            throw new StudentException("Delete Unsuccessful", 400);
        }
        ResponseMessage res = new ResponseMessage();
        res.setMessage("OK");
        res.setStatus(200);
        return res;
    }

    public ResponseMessage update(int id, StudentCreateModel s) throws StudentException {

        if(id < 0 || (!studentValidator.isValid(s))){
            throw new StudentException("Parameter not match", 401);
        }
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new StudentException("Id Not Found", 401);
        }
        if(!studentRepository.update(id,s)){
            throw new StudentException("Update Unsuccessful", 400);
        }
        ResponseMessage res = new ResponseMessage();
        res.setMessage("OK");
        res.setStatus(200);
        return res;
    }

    public ResponseMessage getTopScore(int top) throws StudentException {
        if(top < 0){
            throw new StudentException("Parameter not match", 401);
        }
        ResponseMessage res = new ResponseMessage();
        res.setMessage("OK");
        res.setStatus(200);
        List<StudentResponse> list = new ArrayList<StudentResponse>();
        for(Student s: studentRepository.getTopScore(top)){
            list.add(new StudentResponse(s.getStudentId(),s.getStudentName(),s.getStudentAddress(),s.getStudentScore()));
        }
        res.setData(list);
        return res;
    }
}
