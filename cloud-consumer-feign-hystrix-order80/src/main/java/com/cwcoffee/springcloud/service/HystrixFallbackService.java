package com.cwcoffee.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author cw
 * @Date 2020/07/06 10:51
 */
@Component
public class HystrixFallbackService implements HystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "HystrixService---paymentInfo_ok--o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "HystrixService---paymentInfo_timeout--o(╥﹏╥)o";
    }
}
