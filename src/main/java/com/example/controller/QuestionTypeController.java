package com.example.controller;

import com.example.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/questiontype")
public class QuestionTypeController {

    @Autowired
    QuestionTypeService questionTypeService;
}
