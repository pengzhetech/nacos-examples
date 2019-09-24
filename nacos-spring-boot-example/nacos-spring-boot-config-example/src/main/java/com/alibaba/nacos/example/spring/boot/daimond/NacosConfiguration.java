package com.alibaba.nacos.example.spring.boot.daimond;

import java.util.List;
import java.util.Map;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "11.239.163.65:8848"))
@NacosConfigurationProperties(dataId = "daimond", groupId = "daimond",
    autoRefreshed = true, type = ConfigType.JSON)
public class NacosConfiguration {
    private int showNewGameCardStyle;
    private boolean useLocalCache;
    private String stageTwoAtmosphereColor;
    private List<String> stageTwoAtmosphereModules;
    private Map<String, String> stageOneCampaignBeginTime;

}