package com.example.controller;

import com.example.model.*;
import com.example.service.PollRoleService;
import com.example.service.PollService;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "api/polls")
@CrossOrigin(origins = "*")
public class PollController {

    @Autowired
    PollService pollService;
    @Autowired
    PollRoleService pollRoleService;
    @Autowired
    QuestionService questionService;

//    Хэрэглэгчийн Role-оос шалтгаалж санал асуулгыг авах
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public List findByUserRole(@PathVariable("id") int id) {
        return pollService.getPollFindByUserRole(id);
    }

//    Санал асуулга нэмэх
    @RequestMapping(value = "", method = RequestMethod.POST)
    public List<Question> addPoll(@RequestBody Poll newPoll) {
        Poll poll = pollService.addPoll(newPoll);
        ArrayList<Integer> userRoles = newPoll.getUserRoleId();
        pollRoleService.addPolRole(poll, userRoles);
        questionService.addQuestionss(newPoll.getQuestions(), poll.getPollId());
        return newPoll.getQuestions();
    }
}