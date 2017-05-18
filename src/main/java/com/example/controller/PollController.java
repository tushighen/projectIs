package com.example.controller;

import com.example.model.Poll;
import com.example.model.PollRole;
import com.example.model.User;
import com.example.model.UserRole;
import com.example.service.PollRoleService;
import com.example.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
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
//    {
//        "pollName": "HAHAH",
//            "createdDate": -5359420800000,
//            "modifiedDate": null,
//            "active": true,
//            "user": {
//        "userId": 3
//    },
//        "userRoleId": [1, 2, 3]
//    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addPoll(@RequestBody Poll newPoll) {
        Poll poll = pollService.addPoll(newPoll);
        ArrayList<Integer> userRoles = newPoll.getUserRoleId();
        pollRoleService.addPolRole(poll, userRoles);
    }
}