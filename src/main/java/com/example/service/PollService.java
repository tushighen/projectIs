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
    @Autowired
    PollAnswerService pollAnswerService;

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
        setUser(polls);
        return removeCustom(polls);
    }

    public List getPollsByUserId(int id) {
        List<Poll> polls = pollRepository.findByUser(userService.getUser(id));
        setStatus(polls);
        return removeCustom(polls);
    }

    public Poll getPoll(int id) {
        Poll poll = new Poll();
        poll = pollRepository.findOne(id);
        Date todayDate = new Date();
        if (poll.getStartDate().before(todayDate)) {
            poll.setStarted(true);
            if (poll.getEndDate().before(todayDate))
                poll.setExpired(true);
            else poll.setExpired(false);
        } else {
            poll.setStarted(false);
            if (poll.getEndDate().before(todayDate))
                poll.setExpired(true);
            else poll.setExpired(false);
        }

        for (int i = 0; i < poll.getQuestions().size(); i++) {
            for (int j = 0; j < poll.getQuestions().get(i).getOptionChoices().size(); j++) {
                if (poll.getQuestions().get(i).getOptionChoices().get(j).getCustom() != null)
                    poll.getQuestions().get(i).getOptionChoices().remove(j);
            }
        }

        for (int i = 0; i < poll.getQuestions().size(); i++) {
            poll.getQuestions().get(i).setType(poll.getQuestions().get(i).getQuestionType().getTypeName());
        }

        questionService.setGeneralStat(poll.getQuestions());

        return poll;
    }

    public Poll removePoll(int id) {
        Poll poll = pollRepository.findOne(id);
        pollRepository.delete(id);
        return poll;
    }

    public Poll editPoll(Poll editPoll) {
        Poll poll = pollRepository.findOne(editPoll.getPollId());
        Date date = new Date();
        poll.setPollName(editPoll.getPollName());
        poll.setPollDescription(editPoll.getPollDescription());
        poll.setStartDate(editPoll.getStartDate());
        poll.setEndDate(editPoll.getEndDate());
        poll.setPrivate(editPoll.getPrivate());
//        editPoll.setCreatedDate(poll.getCreatedDate());
        poll.setModifiedDate(date);
        poll.setPollAnswers(null);
        pollRepository.save(poll);
//        questionService.editQuestions(editPoll.getQuestions(), editPoll.getPollId());
        return poll;
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

    private void setUser(List<Poll> polls) {
        for (int i = 0; i < polls.size(); i++) {
            int guest = 1;
            for (int j = 0; j < polls.get(i).getPollAnswers().size(); j++) {
                if (polls.get(i).getPollAnswers().get(j).getUser() != null)
                    polls.get(i).getPollAnswers().get(j).setUserEmail(polls.get(i).getPollAnswers().get(j).getUser().getEmail());
                else {
                    polls.get(i).getPollAnswers().get(j).setUserEmail("guest" + guest);
                    guest++;
                }
            }
        }
    }
}