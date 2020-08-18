package com.hui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/admin")
public class StudentController {

    @RequestMapping("/add")
    public String addStudent() {
        return "/student/add";
    }

    @RequestMapping("/update")
    public String updateStudent() {
        return "/student/update";
    }

    @RequestMapping("/delete")
    public String deleteStudent() {
        return "/student/delete";
    }

    @RequestMapping("/find")
    public String findStudent() {
        return "/student/find";
    }
}
