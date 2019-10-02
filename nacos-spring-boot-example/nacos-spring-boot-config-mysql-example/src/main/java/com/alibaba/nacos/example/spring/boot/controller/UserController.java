/*
package com.alibaba.nacos.example.spring.boot.controller;

import com.alibaba.nacos.example.spring.boot.model.User;
import com.alibaba.nacos.example.spring.boot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping
    public User get(@RequestParam int id) {
        return userService.findById(id);
    }

    @GetMapping("/get/{userId}")
    public User getUser(@PathVariable(value = "userId") Integer userId) {
        return userService.findById(1);
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.insert(user);
    }
}*/
