package com.liaojiexin.springcloud.service.impl;

import com.liaojiexin.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PaymentServiceImpl
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 10:29
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String payment_ok(Integer id) {
        String result="线程池："+Thread.currentThread().getName()+";接口payment_ok,id:"+id;
        System.out.println(result);
        return result;
    }

    /**
     * 超时会导致服务降级，详细看脑图服务降级
     * @param id
     * @return
     */
    @Override
    public String payment_timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result="线程池："+Thread.currentThread().getName()+";接口payment_timeout,id"+id;
        System.out.println(result);
        return result;
    }
}
