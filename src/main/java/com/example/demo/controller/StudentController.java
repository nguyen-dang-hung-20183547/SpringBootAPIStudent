package com.example.demo.controller;

import com.example.demo.model.StudentCreateModel;
import com.example.demo.response.ResponseMessage;
import com.example.demo.service.ServiceInterface;
import com.example.demo.studentException.StudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController extends BaseController{

    @Autowired
    private ServiceInterface studentService;

    @GetMapping(value = "/student/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> findById(@PathVariable Integer id){
        String msg;
        int code;
        try {
            ResponseMessage byId = studentService.findById(id);
            String s = gson.toJson(byId, ResponseMessage.class);
            return new ResponseEntity<>(s, HttpStatus.OK);
        } catch (StudentException e) {
            msg = e.getMessage();
            code = e.getCode();
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                gson.toJson(
                        new ResponseMessage(msg, code), ResponseMessage.class
                ),
                HttpStatus.OK);
    }

    @PostMapping(value = "/student", produces = "application/json; charset = UTF-8")
    public ResponseEntity<String> insertStudent(@RequestBody StudentCreateModel s) {
        String msg;
        int code;
        try {
            ResponseMessage insert = studentService.insert(s);
            String res = gson.toJson(insert, ResponseMessage.class);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (StudentException e) {
            msg = e.getMessage();
            code = e.getCode();
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                gson.toJson(
                        new ResponseMessage(msg, code), ResponseMessage.class
                ),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/student/{id}", produces = "application/json; charset = UTF-8")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        String msg;
        int code;
        try {
            ResponseMessage delById = studentService.deleteById(id);
            String res = gson.toJson(delById, ResponseMessage.class);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (StudentException e) {
            msg = e.getMessage();
            code = e.getCode();
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                gson.toJson(
                        new ResponseMessage(msg, code), ResponseMessage.class
                ),
                HttpStatus.OK);
    }

    @PutMapping(value = "/student/{id}", produces = "application/json; charset = UTF-8")
    public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody StudentCreateModel s){
        String msg;
        int code;
        try {
            ResponseMessage update = studentService.update(id, s);
            String res = gson.toJson(update,ResponseMessage.class);
            return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (StudentException e) {
            msg = e.getMessage();
            code = e.getCode();
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                gson.toJson(
                        new ResponseMessage(msg, code), ResponseMessage.class
                ),
                HttpStatus.OK);
    }

    @GetMapping(value = "/student/top/{top}", produces = "application/json; charset = UTF-8")
    public ResponseEntity<String> findTopScore(@PathVariable Integer top){
        String msg;
        int code;

        try {
            ResponseMessage topScore = studentService.getTopScore(top);
            String res = gson.toJson(topScore,ResponseMessage.class);
            return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (StudentException e) {
            msg = e.getMessage();
            code = e.getCode();
            e.printStackTrace();
        }
        return new ResponseEntity<>(
                gson.toJson(new ResponseMessage(msg,code)
                ),
                HttpStatus.OK
        );
    }
}
