package com.liaojiexin.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import com.liaojiexin.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PaymentController
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 10:35
 */
@RestController
@Slf4j
public class PaymentController {

//    @Autowired    //Autowired和Resource都可以，Resource是jdk的，Autowired是spring的
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    //服务降级
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST},value="/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return paymentService.payment_ok(id);
    }

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST},value="/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        return paymentService.payment_timeout(id);
    }

    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentcircuttBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        System.out.println("paymentcircuttBreaker接口："+result);
        return result;
    }
}
