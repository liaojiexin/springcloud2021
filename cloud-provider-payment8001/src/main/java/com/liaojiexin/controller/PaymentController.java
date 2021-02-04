package com.liaojiexin.controller;

import com.liaojiexin.entity.CommonResult;
import com.liaojiexin.entity.Payment;
import com.liaojiexin.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentController
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 10:35
 */
@RestController
@Slf4j
public class PaymentController {

//    @Autowired    //Autowired和Resource都可以，Resource是jdk的，Autowired是spring的
    @Resource
    private PaymentService paymentService;

    /** 添加支付记录*/
    @RequestMapping(value = "/springcloud/payment/create",method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.insertSelective(payment);
        log.info(String.valueOf(result));
        if (result>0){
            return CommonResult.ok();
        }else{
            return CommonResult.error();
        }
    }

    /** 根据id查询支付记录*/
    @RequestMapping(value = "/springcloud/payment/select/{id}",method = RequestMethod.GET)
    public CommonResult selcet(@PathVariable("id") Long id){
        Payment payment=paymentService.selectByPrimaryKey(id);
//        log.info(payment.toString());
        if (payment!=null){
            return new CommonResult(0,"查询成功",payment);
        }else{
            return new CommonResult(-1,"没有查询到相关记录");
        }
    }
}
