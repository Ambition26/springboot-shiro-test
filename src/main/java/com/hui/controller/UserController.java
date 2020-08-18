package com.hui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/user")
public class UserController {

    @RequestMapping("/add")
    public String addStudent() {
        return "/user/add";
    }

    @RequestMapping("/update")
    public String updateStudent() {
        return "/user/update";
    }

    @RequestMapping("/delete")
    public String deleteStudent() {
        return "/user/delete";
    }

    @RequestMapping("/find")
    public String findStudent() {
        return "/user/find";
    }
}
