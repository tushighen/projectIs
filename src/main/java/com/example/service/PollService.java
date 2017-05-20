package com.example.service;

import com.example.model.Poll;
import com.example.model.PollRole;
import com.example.model.Question;
import com.example.model.UserRole;
import com.example.repository.PollRepository;
import com.example.repository.PollRoleRepository;
import com.example.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PollService {

    @Autowired
    PollRepository pollRepository;
    @Autowired
    PollRoleRepository pollRoleRepository;
    @Autowired
    QuestionRepository questionRepository;

    public List getlAllPoll() {
        return pollRepository.findAll();
    }

//    Хэрэглэгчийн Role-оос шалтгаалж санал асуулгыг авах
    public List getPollFindByUserRole(int id) {
        UserRole userRole = new UserRole();
        userRole.setUserRoleId(id);
        List<PollRole> pollRoles = pollRoleRepository.findByUserRole(userRole);
        List<Poll> polls = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < pollRoles.size(); i++) {
            polls.add(pollRoles.get(i).getPoll());
            questions = questionRepository.findByPoll(pollRoles.get(i).getPoll());
            for (int j = 0; j < questions.size(); j++) {
                questions.get(j).setType(questions.get(j).getQuestionType().getTypeName());
            }
            polls.get(i).setQuestions(questions);
        }
        return polls;
    }

//    Санал асуулга нэмэх
    public Poll addPoll(Poll poll) {
        return pollRepository.save(poll);
    }
}
