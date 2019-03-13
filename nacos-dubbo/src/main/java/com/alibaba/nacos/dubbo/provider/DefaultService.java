package com.alibaba.nacos.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.nacos.dubbo.api.DemoService;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${demo.service.version}")
public class DefaultService implements DemoService {

    @Value("${demo.service.name}")
    private String serviceName;

    public String sayName(String name) {
        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
                serviceName,
                rpcContext.getLocalPort(),
                rpcContext.getMethodName(),
                name,
                name);
    }
}