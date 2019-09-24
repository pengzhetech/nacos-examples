package com.alibaba.nacos.example.spring.boot.controller;

import java.util.List;

import com.alibaba.nacos.example.spring.boot.daimond.NacosConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class ConfigController {

    @Autowired
    private NacosConfiguration nacosConfiguration;

    @GetMapping("/getInt")
    public int getString() {
        return nacosConfiguration.getShowNeweGameCardStyle();
    }

    @GetMapping("/getBoolean")
    public boolean getBoolean() {
        return nacosConfiguration.isUseLocalCache();
    }

   /* @GetMapping("/getList")
    public List<String> getList() {
        return nacosConfiguration.getStageTwoAtmosphereModules();
    }*/

}