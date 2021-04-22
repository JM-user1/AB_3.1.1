package com.jmtask.spring_springboot.controller;


import com.jmtask.spring_springboot.converter.Converter;
import com.jmtask.spring_springboot.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/")
@Transactional
public class UsersController {

    final Converter converter;

    public UsersController(Converter converter) {
        this.converter = converter;
    }


    @GetMapping("userPage")
    public ModelAndView showUserForm(@AuthenticationPrincipal User user) {
        ModelAndView modelAndView = new ModelAndView("/user/userPage");
        String stringRoles = converter.roleSetToString(user);
        modelAndView.addObject("userData", user);
        modelAndView.addObject("userRoles", stringRoles);
        return modelAndView;
    }
}
