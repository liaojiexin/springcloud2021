package com.liaojiexin.springcloud.service;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author liao
 * @Date 9:45 下午 2022/9/27
 **/
@Service
@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceImpl.class)   //这里必须写name或者value来指明调用哪个服务，要和注册中心上面一样的名称
public interface PaymentService {

    @GetMapping("/paymentSql/{id}")
    CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
