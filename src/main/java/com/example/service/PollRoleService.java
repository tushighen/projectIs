package com.example.service;

import com.example.model.Poll;
import com.example.model.PollRole;
import com.example.model.UserRole;
import com.example.repository.PollRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollRoleService {

    @Autowired
    PollRoleRepository pollRoleRepository;

    public List getAllPollRole() {
        return pollRoleRepository.findAll();
    }

    public void addPolRole(Poll poll, ArrayList<Integer> userRoleId) {
        for (int i = 0; i < userRoleId.size(); i++) {
            PollRole pollRole = new PollRole();
            pollRole.setPoll(poll);
            UserRole userRole = new UserRole();
            userRole.setUserRoleId(userRoleId.get(i));
            pollRole.setUserRole(userRole);
            pollRoleRepository.save(pollRole);
        }
    }
}