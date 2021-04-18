package com.jmtask.spring_springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartedController {

    @GetMapping("/")
    public String LoginPage(){
        return "login";
    }


}
