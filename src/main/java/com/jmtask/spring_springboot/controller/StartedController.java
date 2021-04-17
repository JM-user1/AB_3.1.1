package com.jmtask.spring_springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartedController {

    @GetMapping("/login")
    public String LoginPage(){
        return "login";
    }

    @GetMapping("/")
    public String StartPage(){
        return "../static/started-page";
    }

}
