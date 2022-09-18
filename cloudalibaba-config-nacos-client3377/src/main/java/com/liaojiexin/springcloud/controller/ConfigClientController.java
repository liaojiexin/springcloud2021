package com.liaojiexin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope   //支持nacos刷新配置
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String info;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return info+";port:"+serverPort;
    }
}