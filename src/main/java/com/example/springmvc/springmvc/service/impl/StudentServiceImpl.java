package com.example.springmvc.springmvc.service.impl;

import com.example.springmvc.springmvc.model.StudentInfo;
import com.example.springmvc.springmvc.repository.StudentRepository;
import com.example.springmvc.springmvc.service.StudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StudentInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public List<StudentInfo> findByName(String name) {
        return repository.findByFirstName(name);
    }

    @Override
    public StudentInfo save(StudentInfo studentInfo) {
        return repository.save(studentInfo);
    }

    //TODO optimize this
    @Override
    public void deleteById(int id) {
        Optional<StudentInfo> studentInfo = repository.findById(id);
        if (studentInfo.isEmpty()) {
            throw new RuntimeException("No User Found.");
        }
        repository.delete(studentInfo.get());
    }
}
