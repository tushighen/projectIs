package com.example.service;

import com.example.model.Poll;
import com.example.model.PollAnswer;
import com.example.repository.PollAnswerRepository;
import com.example.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollAnswerService {

    @Autowired
    PollAnswerRepository pollAnswerRepository;

    public List getAllPollAnswer() {
        return pollAnswerRepository.findAll();
    }

    public PollAnswer addPollAnswer(PollAnswer addPollAnswer) {
        PollAnswer pollAnswer = addPollAnswer;
        pollAnswerRepository.save(pollAnswer);
        return pollAnswer;
    }

//    public List addUser(Poll poll) {
//        List<PollAnswer> pollAnswers = new ArrayList<>();
//        pollAnswers = poll.getPollAnswers();
//        return pollAnswers;
//    }
}