package com.liaojiexin.springcloud.controller;

import com.liaojiexin.springcloud.service.impl.MessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author liao
 * @Date 6:05 下午 2022/9/10
 **/
@RestController
public class SendMessageController {

    @Resource
    private MessageProviderImpl messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
