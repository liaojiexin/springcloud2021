package com.liaojiexin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: Payment8001Application
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/3 17:18
 */
@EnableEurekaClient
@SpringBootApplication
public class HystrixPayment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001Application.class, args);
    }
}
