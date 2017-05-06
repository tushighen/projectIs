package com.example.service;

import com.example.model.Poll;
import com.example.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    @Autowired
    PollRepository pollRepository;

    public List getlAllPoll() {
        return pollRepository.findAll();
    }
}
