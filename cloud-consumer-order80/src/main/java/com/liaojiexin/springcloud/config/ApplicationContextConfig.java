package com.liaojiexin.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfig
 * @Description: TODO
 * @version: 1.0
 * @author: liaojiexin
 * @date: 2021/2/4 14:39
 */
@Configuration
public class ApplicationContextConfig {

    @Bean       //相当于spring框架中applicationContext.xml <bean id="" class="">
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
