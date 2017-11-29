package com.example.service;

import com.example.model.MaxChoice;
import com.example.repository.GeneralStatisticsRepository;
import com.example.repository.MaxChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StatisticService {

    @Autowired
    MaxChoiceRepository maxChoiceRepository;
    @Autowired
    GeneralStatisticsRepository generalStatisticsRepository;

    public List getMaxChoice(int id) {
        List<MaxChoice> maxChoices = maxChoiceRepository.findByPollId(id);
        return maxChoices;
    }

    public List getGeneralStat(int id) {
        return generalStatisticsRepository.findByPollId(id);
    }

    public List findByQuestionId(int id) {
        return generalStatisticsRepository.findByQuestionId(id);
    }
}