package com.jmtask.spring_springboot.service;

import com.jmtask.spring_springboot.model.UserRole;
import com.jmtask.spring_springboot.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    public final RoleRepo roleRepo;

    public RoleServiceImp(RoleRepo roleRepo) {

        this.roleRepo = roleRepo;
    }

    @Override
    public Set<UserRole> getRoleSet(Set<String> roles) {

        return roleRepo.getRolesByNameIn(roles);
    }

    @Override
    public UserRole getDefaultRole() {
        String defaultRoleName = "USER";
        return roleRepo.getRoleByName(defaultRoleName);
    }
}
