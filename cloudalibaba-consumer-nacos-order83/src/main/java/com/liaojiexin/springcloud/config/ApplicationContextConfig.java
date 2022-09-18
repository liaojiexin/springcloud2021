package com.liaojiexin.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Description TODO
 * @Author liao
 * @Date 8:00 下午 2022/9/18
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //这里必须要加这个注解，nacos里面使用了ribbon，否则会报错
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
