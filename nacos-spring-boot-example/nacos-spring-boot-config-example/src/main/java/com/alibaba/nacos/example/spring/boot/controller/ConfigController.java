package com.alibaba.nacos.example.spring.boot.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.example.spring.boot.daimond.NacosConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.alibaba.nacos.api.common.Constants.DEFAULT_GROUP;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    @NacosValue(value = "${people.enable:false}", autoRefreshed = true)
    private String enable;

    @NacosInjected
    private ConfigService configService;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get(@RequestParam String dataId, @RequestParam(defaultValue = DEFAULT_GROUP) String groupId) throws
        NacosException {
        return configService.getConfig(dataId, groupId, TimeUnit.SECONDS.toMillis(1));
    }

    @RequestMapping()
    @ResponseBody
    public String value() {
        return enable;
    }

    @RequestMapping(value = "/publish", method = POST)
    @ResponseBody
    public boolean publish(@RequestParam String dataId, @RequestParam(defaultValue = DEFAULT_GROUP) String groupId,
        @RequestParam String content) throws NacosException {
        return configService.publishConfig(dataId, groupId, content);
    }

    @GetMapping("/switch")
    public boolean testSwitch() {
        return nacosConfiguration.isUseLocalCache();
    }

}