package com.alibaba.nacos.example.spring.boot.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.nacos.example.spring.boot.daimond.NacosConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {
 * "showNewGameCardStyle":555,
 * "useLocalCache":true,
 * "stageTwoAtmosphereModules":[
 * "bannerSlider",
 * "channels",
 * "scrollChannels",
 * "countdown",
 * "featureddailybanner",
 * "featuredcampaignbanner",
 * "newVisitorV2",
 * "crazyDeal",
 * "hotDeals",
 * "marketingcard"
 * ],
 * "stageOneCampaignBeginTime":{
 * "id":"2019-7-5T00:00:00.000+07:00",
 * "my":"2019-7-5T00:00:00.000+08:00",
 * "ph":"2019-7-5T00:00:00.000+08:00",
 * "sg":"2019-7-5T00:00:00.000+08:00",
 * "th":"2019-7-5T00:00:00.000+07:00",
 * "vn":"2019-7-5T00:00:00.000+07:00"
 * }
 * }
 */
@RestController
@RequestMapping("config")
public class ConfigController {

    @Autowired
    private NacosConfiguration nacosConfiguration;

    @GetMapping("/getInt")
    public int getInt() {
        return nacosConfiguration.getShowNewGameCardStyle();
    }

    @GetMapping("/getBoolean")
    public boolean getBoolean() {
        return nacosConfiguration.isUseLocalCache();
    }

    @GetMapping("/getList")
    public List<String> getList() {
        return nacosConfiguration.getStageTwoAtmosphereModules();
    }

    @GetMapping("/getMap")
    public Map<String, String> getMap() {
        return nacosConfiguration.getStageOneCampaignBeginTime();
    }

}