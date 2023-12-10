package com.example.springmvc.springmvc.controller;

import com.example.springmvc.springmvc.model.StudentInfo;
import com.example.springmvc.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/findAll")
    public String getAllStudentForm(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/student-list";

    }

    @GetMapping("/addStudent")
    public String addStudentForm(Model model) {
        StudentInfo student = new StudentInfo();
        model.addAttribute("student", student);
        return "student/student-form-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") StudentInfo student) {
        studentService.save(student);
        //use redirect to prevent duplicate submission
        return "redirect:/students/findAll";
    }

    @GetMapping("updateStudent")
    public String updateStudentForm(@RequestParam("studentId") int studentId, Model model) {
        StudentInfo info = studentService.findById(studentId);
        model.addAttribute("student", info);
        return "student/student-form-add";
    }

    @GetMapping("deleteStudent")
    public String deleteStudentForm(@RequestParam("studentId") int studentId) {
        studentService.deleteById(studentId);
        return "redirect:/students/findAll";
    }

}
