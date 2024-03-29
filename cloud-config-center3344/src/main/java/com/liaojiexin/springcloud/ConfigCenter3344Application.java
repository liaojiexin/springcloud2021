package com.liaojiexin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //开启configserver
public class ConfigCenter3344Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344Application.class, args);
    }

}
