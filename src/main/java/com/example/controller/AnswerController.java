package com.example.controller;

import com.example.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/answers")
@CrossOrigin(origins = "*")
public class AnswerController {

    @Autowired
    AnswerService answerService;
}
