package com.liaojiexin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
public class OrderFeign80Appliacion {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80Appliacion.class,args);
    }
}
