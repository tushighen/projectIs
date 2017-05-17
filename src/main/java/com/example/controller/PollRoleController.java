package com.example.controller;

import com.example.model.Poll;
import com.example.model.PollRole;
import com.example.model.UserRole;
import com.example.service.PollRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/pollroles")
@CrossOrigin(origins = "*")
public class PollRoleController {

    @Autowired
    PollRoleService pollRoleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Poll getAllPollRole() {
        List<PollRole> pollRoles = pollRoleService.getAllPollRole();
        return pollRoles.get(1).getPoll();
    }
}