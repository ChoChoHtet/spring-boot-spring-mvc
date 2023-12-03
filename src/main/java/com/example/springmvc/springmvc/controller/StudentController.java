package com.example.springmvc.springmvc.controller;

import com.example.springmvc.springmvc.model.Student;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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

    /**
     * @param webDataBinder - preprocessor every string form data and remove leading and trailing whitespace
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

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

    /**
     * @param theStudent    -it will populate student object here
     * @param bindingResult - the result of validation
     * @return template form name
     */
    @PostMapping("/processStudentFrom")
    public String processForm(@Valid @ModelAttribute("student") Student theStudent,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student-form";
        }
        return "student-confirmation";

    }
}
