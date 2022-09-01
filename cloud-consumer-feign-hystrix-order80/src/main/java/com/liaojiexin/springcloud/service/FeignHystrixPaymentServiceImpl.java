package com.liaojiexin.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName FeignHystrixPaymentServiceImpl
 * @Description TODO    这里实现带有@FeignClient注解的FeignPaymentService方法，这里的类里面的方法是接口类的降级兜底方法
 * @Author liao
 * @Date 9:27 下午 2022/9/1
 **/
@Component
public class FeignHystrixPaymentServiceImpl implements FeignPaymentService{
    @Override
    public String payment_ok(Integer id) {
        return "FeignHystrixPaymentServiceImpl方法：payment_ok请求超时，请稍后再试";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "FeignHystrixPaymentServiceImpl方法：payment_timeout请求超时，请稍后再试";
    }
}
