package com.liaojiexin.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GateWayConfig
 * @Description TODO
 * @Author liao
 * @Date 10:16 上午 2022/9/4
 **/
@Configuration
public class GateWayConfig {

    /**
     * 这里是gateway网关的第二种配置映射方法，第一种是直接在application.yml里面配置
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocation(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        //映射到http://news.baidu.com/guonei这个网址,访问localhost:9527/guonei就会跳转到http://news.baidu.com/guonei
        RouteLocator id_path = routes.route("id_path",
                r -> r.path("/guonei").uri("http://news.baidu.com")).build();
        return id_path;
    }

}
