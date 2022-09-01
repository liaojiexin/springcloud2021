package com.liaojiexin.springcloud.service;

import com.liaojiexin.springcloud.entity.Payment;

/**
 * @ClassName: PaymentService
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 10:29
 */
public interface PaymentService {

    String payment_ok(Integer id);


    String payment_timeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
