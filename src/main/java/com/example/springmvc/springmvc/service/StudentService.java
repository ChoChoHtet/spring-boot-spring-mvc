package com.example.springmvc.springmvc.service;

import com.example.springmvc.springmvc.model.StudentInfo;
import java.util.List;

public interface StudentService {
    List<StudentInfo> findAll();

    List<StudentInfo> findByName(String name);

    StudentInfo save(StudentInfo studentInfo);

    void deleteById(int id);

}
