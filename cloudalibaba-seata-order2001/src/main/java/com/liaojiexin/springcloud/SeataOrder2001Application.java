package com.liaojiexin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启OpenFeign
public class SeataOrder2001Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2001Application.class, args);
    }

}
