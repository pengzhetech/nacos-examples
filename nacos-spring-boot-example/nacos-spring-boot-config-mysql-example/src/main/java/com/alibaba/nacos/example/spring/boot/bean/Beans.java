package com.alibaba.nacos.example.spring.boot.bean;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.nacos.example.spring.boot.nacos.NacosConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pengzhe
 * @date 2019-09-24 17:29
 */
@Configuration
public class Beans {

    @Autowired
    private NacosConfig nacosConfig;

    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(nacosConfig.getUrl());
        druidDataSource.setUsername(nacosConfig.getUsername());
        druidDataSource.setPassword(nacosConfig.getPassword());
        return druidDataSource;
    }
}
