package com.example.controller;

import com.example.service.PollRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/pollroles")
@CrossOrigin(origins = "*")
public class PollRoleController {

    @Autowired
    PollRoleService pollRoleService;
}