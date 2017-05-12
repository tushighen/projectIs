package com.example.controller;

import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    QuestionService questionService;
}
