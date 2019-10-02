package com.alibaba.nacos.example.spring.boot.controller;

import com.alibaba.nacos.example.spring.boot.model.User;
import com.alibaba.nacos.example.spring.boot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengzhe
 * @date 2019-09-24 20:45
 */
@RestController("/ok")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String ok() {
        return "OK";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save() {
        return "Save";
    }
}
