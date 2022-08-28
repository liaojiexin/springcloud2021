package com.liaojiexin.springcloud;

import com.liaojiexin.ribbo.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName: OrderAppliacion
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 14:07
 */
@EnableEurekaClient
@SpringBootApplication
//这里启动自定义Ribbon负载均衡决策,name为Eureka中的注册的服务名（注意区分大小写），configuration为自定义的实现类
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRibbonRule.class)
public class Order80Appliacion {

    public static void main(String[] args) {
        SpringApplication.run(Order80Appliacion.class,args);
    }
}
