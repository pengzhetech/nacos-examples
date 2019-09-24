package com.alibaba.nacos.example.spring.boot.nacos;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @author pengzhe
 * @date 2019-09-24 17:23
 */
@Data
@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "11.239.163.65:8848"))
@NacosConfigurationProperties(dataId = "mysql.properties",prefix = "datasource",
    autoRefreshed = true)
public class NacosConfig {

    private String url;
    private String username;
    private String password;

}
