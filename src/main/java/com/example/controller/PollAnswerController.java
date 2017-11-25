package com.example.controller;

import com.example.model.PollAnswer;
import com.example.service.PollAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/pollanswer")
@CrossOrigin(origins = "*")
public class PollAnswerController {

    @Autowired
    PollAnswerService pollAnswerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getPollAnswers() {
        return pollAnswerService.getAllPollAnswer();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public PollAnswer addPollAnswer(@RequestBody PollAnswer addPollAnswer) {
        return pollAnswerService.addPollAnswer(addPollAnswer);
    }
}