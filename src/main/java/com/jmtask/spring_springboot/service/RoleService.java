package com.jmtask.spring_springboot.service;

import com.jmtask.spring_springboot.model.UserRole;
import java.util.Set;

public interface RoleService {
    Set<UserRole> getRoleSet(Set<String> roles);
    UserRole getDefaultRole();

}
