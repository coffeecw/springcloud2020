package com.cwcoffee.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author cw
 * @Date 2020/07/02 10:19
 */
@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        int i = 10 / 0;
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

    //======服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerMethod",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("***id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号:"+serialNumber;
    }

    public String paymentCircuitBreakerMethod(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试o(╥﹏╥)o  id:"+id;
    }

}
