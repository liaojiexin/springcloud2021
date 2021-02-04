package com.liaojiexin.controller;

import com.liaojiexin.entity.CommonResult;
import com.liaojiexin.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    public static final String PAYMENT_URL="http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/springcloud/consumer/payment/create",method = RequestMethod.POST)
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/springcloud/payment/create",payment,CommonResult.class);
    }

    @RequestMapping(value = "/springcloud/consumer/payment/select/{id}",method = RequestMethod.GET)
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/springcloud/payment/select/"+id,CommonResult.class);
    }
}
