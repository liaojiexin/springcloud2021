package com.liaojiexin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelClient8401Application {

    public static void main(String[] args) {
        SpringApplication.run(SentinelClient8401Application.class, args);
    }

}
