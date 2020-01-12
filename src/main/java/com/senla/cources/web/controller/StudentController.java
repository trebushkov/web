package com.senla.cources.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/studentList")
    public String home() {
        return "studentList";
    }

}
