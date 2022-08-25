package com.liaojiexin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: OrderAppliacion
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 14:07
 */
@EnableDiscoveryClient  //开启服务发现
@SpringBootApplication
public class OrderZk80Appliacion {

    public static void main(String[] args) {
        SpringApplication.run(OrderZk80Appliacion.class,args);
    }
}
