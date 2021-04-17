package com.jmtask.spring_springboot.service;


import com.jmtask.spring_springboot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> listUsers();
    void deleteUser(Long id);
    void updateUser(User user);
    User getUserById(Long id);
}
