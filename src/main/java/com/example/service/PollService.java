package com.example.service;

import com.example.model.Poll;
import com.example.model.Question;
import com.example.model.UserRole;
import com.example.repository.PollRepository;
import com.example.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollService {

    @Autowired
    PollRepository pollRepository;
    @Autowired
    QuestionRepository questionRepository;

    public List getlAllPoll() {
        return pollRepository.findAll();
    }


//    Санал асуулга нэмэх
    public Poll addPoll(Poll poll) {
        return pollRepository.save(poll);
    }
}