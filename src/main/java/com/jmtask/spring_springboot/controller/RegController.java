package com.jmtask.spring_springboot.controller;

import com.jmtask.spring_springboot.model.User;
import com.jmtask.spring_springboot.service.RoleService;
import com.jmtask.spring_springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reg")
public class RegController {

    final
    UserService userService;
    final
    RoleService roleService;

    public RegController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public ModelAndView showRegistrationForm(User user) {
        ModelAndView modelAndView = new ModelAndView("reg");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/newUser")
    public String createUser(User user) {
        user.getRoleSet().add(roleService.getDefaultRole());
        userService.addUser(user);
        return "redirect:/";
    }

}
