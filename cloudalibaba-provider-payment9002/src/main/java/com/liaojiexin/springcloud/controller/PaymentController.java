package com.liaojiexin.springcloud.controller;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author liao
 * @Date 10:04 下午 2022/9/13
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/nacos/payment")
    public String get(){
        return "调用成功，端口号："+port;
    }

    public static HashMap<Long, Payment> hashMap=new HashMap<>();

    static {
        hashMap.put(1L,new Payment(1L,"1111"));
        hashMap.put(2L,new Payment(2L,"2222"));
        hashMap.put(3L,new Payment(3L,"3333"));
    }

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        Payment payment=hashMap.get(id);
        CommonResult<Payment> result=new CommonResult<>(200,"请求成功，端口号："+port,payment);
        return result;
    }
}
