package com.liaojiexin.springcloud.service;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import org.springframework.stereotype.Service;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Author liao
 * @Date 9:50 下午 2022/9/27
 **/
@Service
public class PaymentServiceImpl implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSql(Long id) {

        return new CommonResult<>(444,"openfeign,服务降级返回----PaymentServiceImpl----");
    }
}
