package com.cwcoffee.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author cw
 * @Date 2020/07/02 10:19
 */
@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_ok"+id+"\t"+"哈哈哈";
    }

    public String paymentInfo_timeout(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_timeout"+id+"\t"+"哈哈哈"+"  耗时(秒)"+timeNumber;
    }
}
