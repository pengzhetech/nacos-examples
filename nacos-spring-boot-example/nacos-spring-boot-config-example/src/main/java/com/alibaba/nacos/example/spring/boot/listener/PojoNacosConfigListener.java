/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.nacos.example.spring.boot.listener;

import java.util.Date;

import javax.annotation.PostConstruct;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.example.spring.boot.config.PojoNacosConfigConverter;
import com.alibaba.nacos.example.spring.boot.domain.Pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import static com.alibaba.nacos.api.common.Constants.DEFAULT_GROUP;

/**
 * Timeout {@link NacosConfigListener}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see NacosConfiguration
 * @since 0.1.0
 */
@Configuration
public class PojoNacosConfigListener {

    public static final String POJO_DATA_ID = "pojo-data-id";

    /**
     * The data id for {@link System#currentTimeMillis()}
     */
    public static final String CURRENT_TIME_DATA_ID = "time-data-id";

    private static final Logger logger = LoggerFactory.getLogger(PojoNacosConfigListener.class);

    private Pojo pojo = new Pojo();

    @NacosInjected
    private ConfigService configService;

    @PostConstruct
    public void init() throws Exception {
        // Initialize
        pojo.setId("1");
        pojo.setName("mercyblitz");
        pojo.setCreated(new Date());
        // Serialization
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(pojo);
        // Publish
        configService.publishConfig(POJO_DATA_ID, DEFAULT_GROUP, content);
    }

    @NacosConfigListener(dataId = CURRENT_TIME_DATA_ID, converter = PojoNacosConfigConverter.class)
    public void onReceived(Pojo value) throws InterruptedException {
        logger.info("onReceived(Pojo) : {}", value);
    }
}
