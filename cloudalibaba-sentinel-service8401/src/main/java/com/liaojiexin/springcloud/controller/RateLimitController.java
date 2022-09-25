package com.liaojiexin.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liaojiexin.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RateLimitController
 * @Description TODO
 * @Author liao
 * @Date 9:47 下午 2022/9/25
 **/
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value="byResource",blockHandler="handleException")
    public String byResource(){
        return "按资源名称限流测试oK";
    }
    public String handleException(BlockException exception){
        return exception.getClass().getCanonicalName()+";服务不可用";
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public String byUrl(){
        return "按url限流测试oK";
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException")
    public String customerBlockHandler(){
        return "客户自定义逻辑处理";
    }
}
