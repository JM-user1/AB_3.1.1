package com.jmtask.spring_springboot.controller;

import com.jmtask.spring_springboot.model.User;
import com.jmtask.spring_springboot.model.UserRole;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Converter {

    public String roleSetToString(User user) {
        return user.getRoleSet()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.joining(", "));
    }

}
