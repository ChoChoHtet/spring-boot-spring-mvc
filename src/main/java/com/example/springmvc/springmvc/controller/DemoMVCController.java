package com.example.springmvc.springmvc.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoMVCController {
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("theDate",new Date());
        return "helloworld";
    }
}
