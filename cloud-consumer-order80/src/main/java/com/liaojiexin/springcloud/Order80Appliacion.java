package com.liaojiexin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: OrderAppliacion
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 14:07
 */
@EnableEurekaClient
@SpringBootApplication
public class Order80Appliacion {

    public static void main(String[] args) {
        SpringApplication.run(Order80Appliacion.class,args);
    }
}
