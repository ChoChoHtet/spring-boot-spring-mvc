package com.example.springmvc.springmvc.repository;

import com.example.springmvc.springmvc.model.StudentInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Integer> {
    List<StudentInfo> findByFirstName(String name);
}
