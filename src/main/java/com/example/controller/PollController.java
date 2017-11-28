package com.example.controller;

import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/polls")
@CrossOrigin(origins = "*")
public class PollController {

    @Autowired
    PollService pollService;
    @Autowired
    QuestionService questionService;
    @Autowired
    PollAnswerService pollAnswerService;
    @Autowired
    PollStatisticsService pollStatisticsService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Poll addPoll(@RequestBody Poll newPoll) {
        pollService.addPoll(newPoll);
        return newPoll;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Poll editPoll(@RequestBody Poll editPoll) {
        return pollService.editPoll(editPoll);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Poll> getPolls() {
        return pollService.getAllPoll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Poll getPoll(@PathVariable("id") int id) {
        return pollService.getPoll(id);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public List<Poll> getPollsByUserId(@PathVariable("id") int id) {
        return pollService.getPollsByUserId(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Poll removePoll(@PathVariable("id") int id) {
        return pollService.removePoll(id);
    }

    @RequestMapping(value = "/fill", method = RequestMethod.POST)
    @ResponseBody
    public PollAnswer addPollAnswer(@RequestBody PollAnswer addPollAnswer) {
        return pollAnswerService.addPollAnswer(addPollAnswer);
    }
}