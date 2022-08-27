package com.liaojiexin.ribbo;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyRibbonRule
 * @Description TODO
 * 自定义Ribbon负载均衡决策，注意：这里不能写在和主启动类同个包和其子包下面，因为主启动中@ComponentScan所扫描的当前包下以及子包下，
 * 否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了。
 * @Author liao
 * @Date 9:49 下午 2022/8/27
 **/
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule MyRibbonRule(){
        return new RandomRule();    //随机策略
    }
}
