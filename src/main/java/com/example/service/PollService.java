package com.example.service;

import com.example.model.Poll;
import com.example.model.Question;
import com.example.model.User;
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
    @Autowired
    UserService userService;

    //    Санал асуулга нэмэх
    public Poll addPoll(Poll poll) {
        Date date = new Date();
        poll.setCreatedDate(date);
        pollRepository.save(poll);
        questionService.addQuestions(poll.getQuestions(), poll.getPollId());
        return poll;
    }

    public List getAllPoll() {
        List<Poll> polls = pollRepository.findAll();
        setStatus(polls);
        return removeCustom(polls);
    }

    public List getPollsByUserId(int id) {
        List<Poll> polls = pollRepository.findByUser(userService.getUser(id));
        setStatus(polls);
        return removeCustom(polls);
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

    private List removeCustom(List<Poll> polls) {
        for (int i = 0; i < polls.size(); i++) {
            for (int j = 0; j < polls.get(i).getQuestions().size(); j++) {
                for (int l = 0; l < polls.get(i).getQuestions().get(j).getOptionChoices().size(); l++) {
                    if (polls.get(i).getQuestions().get(j).getOptionChoices().get(l).getCustom() != null)
                        polls.get(i).getQuestions().get(j).getOptionChoices().remove(l);
                }
            }
        }
        return polls;
    }

    private void setStatus(List<Poll> polls) {
        for (int i = 0; i < polls.size(); i++) {
            for (int l = 0; l < polls.get(i).getQuestions().size(); l++) {
                polls.get(i).getQuestions().get(l).setType(polls.get(i).getQuestions().get(l).getQuestionType().getTypeName());
                Date todayDate = new Date();
                if (polls.get(i).getStartDate().before(todayDate)) {
                    polls.get(i).setStarted(true);
                    if (polls.get(i).getEndDate().before(todayDate))
                        polls.get(i).setExpired(true);
                    else polls.get(i).setExpired(false);

                } else {
                    polls.get(i).setStarted(false);
                    if (polls.get(i).getEndDate().before(todayDate))
                        polls.get(i).setExpired(true);
                    else polls.get(i).setExpired(false);
                }
            }
        }
    }
}