package com.liaojiexin.springcloud.service.impl;

import com.liaojiexin.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName MessageProviderImpl
 * @Description TODO
 * @Author liao
 * @Date 5:54 下午 2022/9/10
 **/
@EnableBinding(Source.class) //@EnableBinding指信道channel和exchange绑定在一起,即这里定义了消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  //消息发送管道

    @Override
    public String send() {
        String uuid= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("8801,uuid:"+uuid);
        return null;
    }
}
