package com.liaojiexin.springcloud.controller;

import com.liaojiexin.springcloud.entity.CommonResult;
import com.liaojiexin.springcloud.entity.Payment;
import com.liaojiexin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${server.port}")
    private String port;

    /** 添加支付记录*/
    @RequestMapping(value = "/springcloud/payment/create",method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.insertSelective(payment);
        log.info(String.valueOf(result));
        if (result>0){
            return new CommonResult(0,"添加成功，端口号："+port,payment);
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
            return new CommonResult(0,"查询成功，端口号："+port,payment);
        }else{
            return new CommonResult(-1,"没有查询到相关记录");
        }
    }


    //------服务发现--------
    //+++++++++++++++++++++++++++++++++
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/springcloud/payment/discovery")
    public CommonResult<DiscoveryClient> discoveryServer(){
        //获取注册中心的所有服务
        List<String> services=discoveryClient.getServices();
        for (String service:services) {
            log.info("获取到服务，服务名称为："+service);
        }

        //获取服务名称为cloud-payment-service的所有集群
        List<ServiceInstance> instances=discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance:instances) {
            log.info("获取服务cloud-payment-service集群中的其中一个;ip:"+instance.getHost()+";port:"+instance.getPort()+";url:"+instance.getUri());
        }

        return new CommonResult<>(0,"查询成功",this.discoveryClient);
    }

    //---------------------------------
}
