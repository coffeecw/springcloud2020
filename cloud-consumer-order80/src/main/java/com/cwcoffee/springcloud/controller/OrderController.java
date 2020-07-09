package com.cwcoffee.springcloud.controller;

import com.cwcoffee.springcloud.entity.CommonResult;
import com.cwcoffee.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author cw
 * @Date 2020/06/28 14:54
 */
@RestController
@Slf4j
public class OrderController {

    //    private static final String PAYMENT_URL="http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/insert")
    public CommonResult insert(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/insert", payment, CommonResult.class);
    }

    @GetMapping("/consumer/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/getEntity/{id}")
    public CommonResult getEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("调用成功");
            return entity.getBody();
        } else {
            log.info("调用失败");
            return new CommonResult(500, "请求失败");
        }
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return result;
    }
}
