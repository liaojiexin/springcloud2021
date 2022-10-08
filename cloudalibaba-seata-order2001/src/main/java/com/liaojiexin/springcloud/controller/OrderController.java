package com.liaojiexin.springcloud.controller;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Order;
import com.liaojiexin.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author liao
 * @Date 9:15 下午 2022/10/2
 **/
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 下订单
     * @param order
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST},value = "/order/create")
    @GlobalTransactional
    public CommonResult create(@RequestBody Order order){
        orderService.create(order);
        return CommonResult.ok();
    }
}
