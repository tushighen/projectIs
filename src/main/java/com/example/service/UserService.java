package com.example.service;

import com.example.model.User;
import com.example.model.UserRole;
import com.example.repository.UserRepository;
import com.example.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    public List getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        User user = userRepository.findOne(id);
        return user;
    }

    public HashMap addUser(User user) {
        HashMap model = new HashMap();
        if (user != null) {
            if (userRepository.findByEmail(user.getEmail()) == null) {
                userRepository.save(user);
                model.put("msg", "Success");
                return model;
            } else {
                model.put("msg", "User exist");
                return model;
            }
        } else {
            model.put("msg", "error");
            return model;
        }
    }

    public User editUser(User user) {
        return userRepository.save(user);
    }

    public void removeUser(int id) {
        userRepository.delete(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public HashMap userLogin(HashMap loginModel) {
        HashMap model = new HashMap();
        User user = userRepository.findByEmail(loginModel.get("email").toString());
        if (user != null) {
            if (loginModel.get("password").toString().equals(user.getPassword())) {
                model.put("msg", "Success");
            } else {
                model.put("msg", "Wrong password");
            }
            return model;
        } else {
            model.put("msg", "User not found");
            return model;
        }
    }

    public User requestDeveloper(User user) {
        return userRepository.save(user);
    }

    public User addDeveloper(User user) {
        return userRepository.save(user);
    }
}