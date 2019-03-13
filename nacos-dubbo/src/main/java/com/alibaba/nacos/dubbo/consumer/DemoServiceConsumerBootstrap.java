package com.alibaba.nacos.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import com.alibaba.nacos.dubbo.api.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;


@EnableDubbo
@PropertySource(value = {"classpath:/consumer-config.properties","classpath:/nacos.xml"})
public class DemoServiceConsumerBootstrap {

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            System.out.println(demoService.sayName("哲哥）"));
        }
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DemoServiceConsumerBootstrap.class);
        context.refresh();
        context.close();
    }
}