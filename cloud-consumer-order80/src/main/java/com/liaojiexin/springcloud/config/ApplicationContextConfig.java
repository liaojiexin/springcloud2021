package com.liaojiexin.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced   //开启负载均衡，如果提供者为集群，且调用服务为服务名则需要开启
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
