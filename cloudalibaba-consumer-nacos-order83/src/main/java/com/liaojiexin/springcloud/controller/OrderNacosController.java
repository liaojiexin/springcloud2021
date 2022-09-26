package com.liaojiexin.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderNacosController
 * @Description TODO
 * @Author liao
 * @Date 8:03 下午 2022/9/18
 **/
@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    private final String PAYMENT_URL="http://nacos-payment-provider";

    @GetMapping(value = "/nacos/consumer")
    public String get(){
        return restTemplate.getForObject(PAYMENT_URL+"/nacos/payment",String.class);
    }

    @GetMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")   //没有配置
    public CommonResult<Payment> paymentSql(@PathVariable Long id){
        CommonResult<Payment> result=restTemplate.getForObject(PAYMENT_URL+"/paymentSql/"+id,CommonResult.class,id);
        if (id==4){
            throw new IllegalArgumentException("非法参数异常");
        }else if (result.getData()==null){
            throw new NullPointerException("空指针异常");
        }
        return result;
    }
}
