package com.cwcoffee.springcloud.controller;

import com.cwcoffee.springcloud.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author cw
 * @Date 2020/07/02 15:42
 */
@RestController
@Slf4j
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        return hystrixService.paymentInfo_ok(id);
    }

//    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    public String paymentInfo_timeout(@PathVariable("id") Integer id){
//        return hystrixService.paymentInfo_timeout(id);
//    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        String result = hystrixService.paymentInfo_timeout(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒钟再试o(╥﹏╥)o";
    }
}
