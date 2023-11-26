package com.example.springmvc.springmvc.controller;

import com.example.springmvc.springmvc.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${operatingSystem}")
    private List<String> operatingSystem;


    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        Student student = new Student();
        //add object to model
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("operatingSystem", operatingSystem);
        return "student-form";
    }

    //it will populate student object here
    @PostMapping("/processStudentFrom")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        System.out.printf("Student Info -> firstname: %s,lastname: %s", theStudent.getFirstName(), theStudent.getLastName());
        return "student-confirmation";

    }
}
