package com.liaojiexin.springcloud.controller;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import com.liaojiexin.springcloud.service.FeignPaymentService;
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

    //查询订单
    @RequestMapping(value = "/springcloud/consumer/payment/select/{id}",method = RequestMethod.GET)
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentService.selcet(1l);
    }

    //新建订单
    @RequestMapping(value = "/springcloud/consumer/payment/create",method = RequestMethod.POST)
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return  paymentService.create(payment);
    }
}
