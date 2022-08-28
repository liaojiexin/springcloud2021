package com.liaojiexin.springcloud.service;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName FeignPaymentService
 * @Description TODO
 * @Author liao
 * @Date 8:16 下午 2022/8/28
 **/
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")   //这里必须写name或者value来指明调用哪个服务，要和Eureka上面一样的名称
public interface FeignPaymentService {

    /** 添加支付记录*/
    //这里调用的是服务提供者提供的接口
    @RequestMapping(value = "/springcloud/payment/create",method = RequestMethod.POST)
    CommonResult create(@RequestBody Payment payment);

    /** 根据id查询支付记录*/
    @RequestMapping(value = "/springcloud/payment/select/{id}",method = RequestMethod.GET)
    CommonResult selcet(@PathVariable("id") Long id);
}
