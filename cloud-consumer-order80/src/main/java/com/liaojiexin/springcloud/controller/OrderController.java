package com.liaojiexin.springcloud.controller;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
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

    //提供者为单机的话可以写死
//    public static final String PAYMENT_URL="http://localhost:8001";
    //提供者集群时不能写死
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    //新建订单
    @RequestMapping(value = "/springcloud/consumer/payment/create",method = RequestMethod.POST)
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/springcloud/payment/create",payment,CommonResult.class);
    }

    //查询订单
    @RequestMapping(value = "/springcloud/consumer/payment/select/{id}",method = RequestMethod.GET)
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/springcloud/payment/select/"+id,CommonResult.class);
    }

    //服务发现
    @RequestMapping(value = "/springcloud/consumer/payment/discovery",method = RequestMethod.GET)
    public CommonResult<Object> getPayment(){
        return restTemplate.getForObject(PAYMENT_URL+"/springcloud/payment/discovery",CommonResult.class);
    }
}
