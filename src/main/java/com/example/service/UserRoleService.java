package com.example.service;

import com.example.model.UserRole;
import com.example.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    public List getUserRole() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles;
    }

    public UserRole getOneUserRole(int id) {
        UserRole userRole = userRoleRepository.findOne(id);
        return userRole;
    }

    public void addRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}