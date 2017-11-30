//package com.example.service;
//
//import com.example.model.MaxChoice;
//import com.example.repository.ChoiceCountRepository;
//import com.example.repository.MaxChoiceRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StatisticService {
//
//    @Autowired
//    MaxChoiceRepository maxChoiceRepository;
//    @Autowired
//    ChoiceCountRepository choiceCountRepository;
//
//    public List getMaxChoice(int id) {
//        List<MaxChoice> maxChoices = maxChoiceRepository.findByPollId(id);
//        return maxChoices;
//    }
//
//    public List getGeneralStat(int id) {
//        return choiceCountRepository.findByPollId(id);
//    }
//
//    public List findByQuestionId(int id) {
//        return choiceCountRepository.findByQuestionId(id);
//    }
//}