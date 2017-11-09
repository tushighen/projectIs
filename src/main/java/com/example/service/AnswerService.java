package com.example.service;

import com.example.model.Answer;
import com.example.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> getAnswers() {
        List<Answer> answers = answerRepository.findAll();
        for (int i = 0; i < answers.size(); i++) {
            answers.get(i).setChoice(answers.get(i).getOptionChoice());
        }
        return answers;
    }

    public List<Answer> addAnswers(List<Answer> addAnswers) {
        List<Answer> answers = new ArrayList();
        for (int i = 0; i < addAnswers.size(); i++) {
            answers.add(answerRepository.save(addAnswers.get(i)));
        }
        return answers;
    }
}