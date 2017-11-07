package com.example.controller;

import com.example.model.Question;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    QuestionService questionService;

}