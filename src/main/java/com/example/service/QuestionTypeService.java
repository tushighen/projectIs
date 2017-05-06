package com.example.service;

import com.example.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeService {

    @Autowired
    QuestionTypeRepository questionTypeRepository;
}
