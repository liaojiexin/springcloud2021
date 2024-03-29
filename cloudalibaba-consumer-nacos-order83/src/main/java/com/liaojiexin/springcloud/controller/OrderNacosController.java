package com.liaojiexin.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import com.liaojiexin.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    //@SentinelResource(value = "fallback")   //没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")   //fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")   //blockHandler只负责sentinel控制台设置
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")   //fallback只负责业务异常,blockHandler只负责sentinel控制台设置
    public CommonResult<Payment> paymentSql(@PathVariable Long id){
        CommonResult<Payment> result=restTemplate.getForObject(PAYMENT_URL+"/paymentSql/"+id,CommonResult.class,id);
        if (id==4){
            throw new IllegalArgumentException("非法参数异常");
        }else if (result.getData()==null){
            throw new NullPointerException("空指针异常");
        }
        return result;
    }

    //本例是fallback
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e){
        Payment payment = new Payment(id,  "null");
        return new CommonResult<>(444,"兜底异常handlerFal1back,exception内容 "+e.getMessage(),payment);
    }

    //本例是blockHandler
    public CommonResult blockHandler (@PathVariable Long id, BlockException blockException){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流，无此流水：blockException"+blockException.getMessage(),payment);
    }

    //sentinel+nacos+openfeign
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/openfeign/paymentSql/{id}")
    CommonResult<Payment> openfeignPaymentSql(@PathVariable("id") Long id){
        return paymentService.paymentSql(id);
    }
}
