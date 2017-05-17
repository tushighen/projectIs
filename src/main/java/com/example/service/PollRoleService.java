package com.example.service;

import com.example.model.UserRole;
import com.example.repository.PollRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollRoleService {

    @Autowired
    PollRoleRepository pollRoleRepository;

    public List getAllPollRole() {
        return pollRoleRepository.findAll();
    }

    public void addPolRole() {

    }
}