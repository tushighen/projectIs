package com.example.controller;

import com.example.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/questiontype")
@CrossOrigin(origins = "*")
public class QuestionTypeController {

    @Autowired
    QuestionTypeService questionTypeService;
}
