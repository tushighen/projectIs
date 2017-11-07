package com.example.service;

import com.example.model.Poll;
import com.example.model.Question;
import com.example.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List getAllQuestion() {
        return questionRepository.findAll();
    }

    public Question addQuestions(Question questions) {
        return questionRepository.save(questions);
    }

    public List findByPoll(Poll poll) {
        return questionRepository.findByPoll(poll);
    }

    public void addQuestionss(List<Question> questions, int pollId) {
        Question question = new Question();
        Poll poll = new Poll();
        poll.setPollId(pollId);
        for (int i = 0; i < questions.size(); i++) {
            question = questions.get(i);
            question.setPoll(poll);
            questionRepository.save(question);
        }
    }
}