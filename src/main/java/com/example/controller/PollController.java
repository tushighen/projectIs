package com.example.controller;

import com.example.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/polls")
@CrossOrigin(origins = "*")
public class PollController {

    @Autowired
    PollService pollService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getAllPoll() {
        return pollService.getlAllPoll();
    }
}
