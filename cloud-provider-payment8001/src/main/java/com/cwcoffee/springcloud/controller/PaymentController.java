package com.cwcoffee.springcloud.controller;

import com.cwcoffee.springcloud.entity.CommonResult;
import com.cwcoffee.springcloud.entity.Payment;
import com.cwcoffee.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author cw
 * @Date 2020/06/28 13:37
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/insert")
    public CommonResult add(@RequestBody Payment payment){
        int insert = paymentService.insert(payment);
        if(insert > 0){
            log.info("插入成功"+payment);
            return new CommonResult(200,"插入成功 "+serverPort,payment);
        }else{
            log.info("插入失败"+insert);
            return new CommonResult(500,"插入失败 "+serverPort,insert);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            log.info("查询成功"+payment);
            return new CommonResult(200,"查询成功 "+serverPort,payment);
        }else{
            log.info("查询失败");
            return new CommonResult(500,"查询失败 "+serverPort);
        }
    }
}
