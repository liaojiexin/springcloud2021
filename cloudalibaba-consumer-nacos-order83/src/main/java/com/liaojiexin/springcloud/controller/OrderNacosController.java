package com.liaojiexin.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderNacosController
 * @Description TODO
 * @Author liao
 * @Date 8:03 下午 2022/9/18
 **/
@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    private final String PAYMENT_URL="http://nacos-payment-provider";

    @GetMapping(value = "/nacos/consumer")
    public String get(){
        return restTemplate.getForObject(PAYMENT_URL+"/nacos/payment",String.class);
    }
}
