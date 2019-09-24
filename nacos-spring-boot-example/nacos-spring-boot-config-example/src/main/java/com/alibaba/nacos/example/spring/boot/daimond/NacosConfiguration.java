package com.alibaba.nacos.example.spring.boot.daimond;

import java.util.List;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "11.239.163.65:8848"))
@NacosConfigurationProperties(dataId = "daimond", groupId = "daimond", autoRefreshed = true)
public class NacosConfiguration {
    private int showNeweGameCardStyle;
    private boolean useLocalCache;

}