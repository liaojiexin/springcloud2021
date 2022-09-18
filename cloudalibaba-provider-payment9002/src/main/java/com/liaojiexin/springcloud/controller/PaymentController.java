package com.liaojiexin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author liao
 * @Date 10:04 下午 2022/9/13
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/nacos/payment")
    public String get(){
        return "调用成功，端口号："+port;
    }
}
