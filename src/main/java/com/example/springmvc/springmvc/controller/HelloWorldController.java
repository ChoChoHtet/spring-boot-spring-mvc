package com.example.springmvc.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //show initial form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld-process";
    }

    @RequestMapping("v2/processForm")
    public String processFormV2(HttpServletRequest request, Model model) {
        //read the request data from data form
        String name = request.getParameter("studentName");
        String message = "Yo! " + name.toUpperCase();
        model.addAttribute("message", message);
        return "helloworld-process-v2";
    }

    //read the request data from data form using @RequestParam Binding
    @RequestMapping("v3/processForm")
    public String processFormV3(@RequestParam("studentName") String name, Model model) {

        String message = "Hey How's going , " + name.toUpperCase() + " ?";
        model.addAttribute("message", message);
        return "helloworld-process-v2";
    }
}
