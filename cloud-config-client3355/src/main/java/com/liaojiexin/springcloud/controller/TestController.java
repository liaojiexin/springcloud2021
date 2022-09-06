package com.liaojiexin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author liao
 * @Date 10:35 下午 2022/9/6
 **/
@RestController
public class TestController {

    //这里获取配置中心服务端中连接gitee上的配置
    @Value("${config.info}")
    private String info;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return info;
    }
}
