package com.liaojiexin.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName GlobalFilterConfig
 * @Description TODO    自定义GateWay过滤器，全局日志记录
 * @Author liao
 * @Date 12:45 下午 2022/9/4
 **/
@Slf4j
@Component
public class MyLogGlobalFilter implements GlobalFilter, Ordered {

//    @Order //和下面的getOrder一样
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=====进入MyLogGlobalFilter=====");
        //获取请求的uname参数
        String uname=exchange.getRequest().getQueryParams().getFirst("uname");
        if (!StringUtils.hasText(uname)){
            log.error("=======uname不能为空=======");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //跳转到后续的过滤器
        return chain.filter(exchange);
    }

    //实现顺序，也可以用@Order注射到上面filter方法
    @Override
    public int getOrder() {
        return 0;
    }
}
