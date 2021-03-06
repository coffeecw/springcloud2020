package com.cwcoffee.springcloud.service.impl;

import com.cwcoffee.springcloud.service.MessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author cw
 * @Date 2020/07/08 16:10
 */
@EnableBinding(Source.class)//定义消息推送的管道
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****serial  "+serial);
        return null;
    }
}
