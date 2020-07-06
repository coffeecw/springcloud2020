package com.cwcoffee.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_timeout(Integer id){
        int timeNumber = 5;
//        int i = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_timeout"+id+"\t"+"哈哈哈"+"  耗时(秒)"+timeNumber;
    }

    public String paymentInfo_timeOutHandle(Integer id){
        return "线程池: "+Thread.currentThread().getName()+"8001系统繁忙或者运行报错，请稍后再试"+id+"\t"+"o(╥﹏╥)o";
    }
}
