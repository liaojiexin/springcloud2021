package com.liaojiexin.springcloud.controller;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import com.liaojiexin.springcloud.service.FeignPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 14:35
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private FeignPaymentService paymentService;

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST},value="/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return paymentService.payment_ok(id);
    }

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST},value="/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "pyamentTimeoutHandler",commandProperties = {
            //设置超时时间为500毫秒时，就会调用pyamentTimeoutHandler方法来做服务降级
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "500")
    })
    public String payment_timeout(@PathVariable("id") Integer id){
        return paymentService.payment_timeout(id);
    }

    //这里payment_timeout方法服务降级后的兜底方法，这里要注意该方法要和调用这个方法的参数相同，
    // 即payment_outtime有一个(Integer id),pyamentTimeoutHandler也要和他一样
    public String pyamentTimeoutHandler(Integer id){
        String result="线程池："+Thread.currentThread().getName()+";80调用8001时服务接口调用繁忙，请稍后再试";
        return result;
    }
}
