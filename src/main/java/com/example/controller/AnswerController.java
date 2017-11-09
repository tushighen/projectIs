package com.example.controller;

import com.example.model.Answer;
import com.example.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/answers")
@CrossOrigin(origins = "*")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Answer> getAnswers() {
        return answerService.getAnswers();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public List<Answer> addAnswers(@RequestBody List<Answer> answers) {
        return answerService.addAnswers(answers);
//        return answers;
    }
}