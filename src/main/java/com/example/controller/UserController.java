package com.example.controller;

import com.example.model.User;
import com.example.service.UserRoleService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getAllUser() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public HashMap userLogin(@RequestBody HashMap model) {
        return userService.userLogin(model);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public HashMap addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public User findByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @RequestMapping(value = "/request", method = RequestMethod.PUT)
    public User requestDeveloper(@RequestBody User user) {
        return userService.requestDeveloper(user);
    }

    @RequestMapping(value = "/developer", method = RequestMethod.PUT)
    public User addDeveloper(@RequestBody User user) {
        return userService.addDeveloper(user);
    }
}