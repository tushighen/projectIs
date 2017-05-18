package com.example.controller;

import com.example.model.Question;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public List addQuestions(@RequestBody List<Question> questions) {
        return questionService.addQuestions(questions);
    }
}
