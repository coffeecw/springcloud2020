package com.cwcoffee.springcloud.controller;

import com.cwcoffee.springcloud.entity.CommonResult;
import com.cwcoffee.springcloud.entity.Payment;
import com.cwcoffee.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/insert")
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

    @GetMapping("/payment/get/{id}")
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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println("instance:"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/timeout")
    public String paymentTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/lb")
    public String paymentLb(){
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
   public String paymentZipkin(){
     return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
  }

}
