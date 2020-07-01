package com.cwcoffee.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author cw
 * @Date 2020/07/01 10:10
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/zk")
    public String consumerzk(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }
}
