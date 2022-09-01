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
//这里必须写name或者value来指明调用哪个服务，要和Eureka上面一样的名称,fallback填写该接口的Hystrix降级方法
//这里和Controller里面的服务降级的区别在于这里主要处理消费者和服务者之前的调用
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback =FeignHystrixPaymentServiceImpl.class)
public interface FeignPaymentService {

    @RequestMapping(method = {RequestMethod.GET},value="/payment/hystrix/ok/{id}")
    String payment_ok(@PathVariable("id") Integer id);

    @RequestMapping(method = {RequestMethod.GET},value="/payment/hystrix/timeout/{id}")
    String payment_timeout(@PathVariable("id") Integer id);
}
