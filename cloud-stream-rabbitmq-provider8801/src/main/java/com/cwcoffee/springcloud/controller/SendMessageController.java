package com.cwcoffee.springcloud.controller;

import com.cwcoffee.springcloud.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author cw
 * @Date 2020/07/08 16:16
 */
@RestController
public class SendMessageController {
    @Resource
    private MessageService messageService;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageService.send();
    }
}
