package com.liaojiexin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: OrderAppliacion
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 14:07
 */
@SpringBootApplication
@EnableFeignClients //开启OpenFeign
@EnableHystrix  //开启Hystrix
public class OrderFeignHystrix80Appliacion {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrix80Appliacion.class,args);
    }
}
