package com.cwcoffee.springcloud.controller;

import com.cwcoffee.springcloud.entity.CommonResult;
import com.cwcoffee.springcloud.entity.Payment;
import com.cwcoffee.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author cw
 * @Date 2020/07/01 16:26
 */
@RestController
@Slf4j
public class PaymentFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
}
