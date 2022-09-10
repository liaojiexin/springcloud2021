package com.liaojiexin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author liao
 * @Date 6:05 下午 2022/9/10
 **/
@Component
@EnableBinding(Sink.class )
public class GetMessageController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("端口："+port+"；收到消息："+message.getPayload());
    }
}
