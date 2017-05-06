package com.example.controller;

import com.example.model.UserRole;
import com.example.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getUserRole() {
        return userRoleService.getUserRole();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addRole(@RequestBody UserRole userRole){
        userRoleService.addRole(userRole);
    }
}