package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.model.StudentCreateModel;

import java.util.List;

public interface StudentRepository {
    public Student findById(Integer id);
    public Iterable<Student> findAll();
    public boolean deleteById(int id);
    public boolean insert(StudentCreateModel s);
    public boolean update(int id,StudentCreateModel s);
    public List<Student> getTopScore(int top);
}
