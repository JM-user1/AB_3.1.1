package com.jmtask.spring_springboot.service;


import com.jmtask.spring_springboot.model.User;
import com.jmtask.spring_springboot.model.UserRole;
import com.jmtask.spring_springboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    UserRepo userRepo;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserServiceImp(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @Transactional
    @Override
    public List<User> listUsers() {

        return userRepo.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {

        userRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {

        userRepo.saveAndFlush(user);
    }

    @Transactional
    @Override
    public User getUserById(Long id) {

        return userRepo.getOne(id);
    }

}
