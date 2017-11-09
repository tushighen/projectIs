package com.example.service;

import com.example.model.Poll;
import com.example.model.Question;
import com.example.model.UserRole;
import com.example.repository.PollRepository;
import com.example.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PollService {

    @Autowired
    PollRepository pollRepository;
    @Autowired
    QuestionService questionService;

    //    Санал асуулга нэмэх
    public Poll addPoll(Poll poll) {
        Date date = new Date();
        poll.setCreatedDate(date);
        pollRepository.save(poll);
        questionService.addQuestions(poll.getQuestions(), poll.getPollId());
        return poll;
    }

    public List getAllPoll() {
        String type;
        List<Poll> polls = pollRepository.findAll();
        for (int i = 0; i < polls.size(); i++) {
            for (int l = 0; l < polls.get(i).getQuestions().size(); l++) {
                polls.get(i).getQuestions().get(l).setType(polls.get(i).getQuestions().get(l).getQuestionType().getTypeName());
            }
        }
        return polls;
    }

    public Poll getPoll(int id) {
        return pollRepository.findOne(id);
    }

    public Poll removePoll(int id) {
        Poll poll = pollRepository.findOne(id);
        pollRepository.delete(id);
        return poll;
    }

    public Poll editPoll(Poll editPoll) {
        Poll poll = pollRepository.findOne(editPoll.getPollId());
        Date date = new Date();
        editPoll.setCreatedDate(poll.getCreatedDate());
        editPoll.setModifiedDate(date);
        pollRepository.save(editPoll);
        questionService.editQuestions(editPoll.getQuestions(), editPoll.getPollId());
        return editPoll;
    }
}