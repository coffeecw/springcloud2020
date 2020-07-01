package com.cwcoffee.springcloud.service;

import com.cwcoffee.springcloud.entity.Payment;

/**
 * @Author cw
 * @Date 2020/06/28 13:34
 */
public interface PaymentService {
    int insert(Payment payment);
    Payment getPaymentById(Long id);
}
