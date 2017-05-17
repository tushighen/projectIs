package com.example.controller;

import com.example.model.User;
import com.example.model.UserRole;
import com.example.service.UserRoleService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List getAllUsers() {
        return userService.getAllUsers();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public HashMap userLogin(@RequestBody HashMap model) {
        return userService.findByFirstName(model);
//        return (String) model.get("password");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable("id") int id) {
        userService.removeStudent(id);
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public User findByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }
}