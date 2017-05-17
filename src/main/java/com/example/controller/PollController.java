package com.example.controller;

import com.example.model.Poll;
import com.example.model.PollRole;
import com.example.model.User;
import com.example.model.UserRole;
import com.example.service.PollRoleService;
import com.example.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/polls")
@CrossOrigin(origins = "*")
public class PollController {

    @Autowired
    PollService pollService;
    @Autowired
    PollRoleService pollRoleService;

//    Хэрэглэгчийн Role-оос шалтгаалж санал асуулгыг авах
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public List findByUserRole(@PathVariable("id") int id) {
        return pollService.getPollFindByUserRole(id);
    }

//    Санал асуулга нэмэх
    @RequestMapping(value = "", method = RequestMethod.POST)
    public int addPoll(@RequestBody Poll poll) {
        return pollService.addPoll(poll).getPollId();
//        return poll.getPollId();
    }
}