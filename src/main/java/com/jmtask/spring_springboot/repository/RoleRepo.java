package com.jmtask.spring_springboot.repository;

import com.jmtask.spring_springboot.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepo extends JpaRepository<UserRole, Long> {
    Set<UserRole> getRolesByNameIn(Set<String> roles);

    UserRole getRoleByName(String defaultRoleName);
}
