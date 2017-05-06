package com.example.service;

import com.example.repository.PollRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollRoleService {

    @Autowired
    PollRoleRepository pollRoleRepository;
}
