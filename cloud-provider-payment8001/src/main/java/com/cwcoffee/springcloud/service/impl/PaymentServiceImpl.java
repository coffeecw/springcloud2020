package com.cwcoffee.springcloud.service.impl;

import com.cwcoffee.springcloud.dao.PaymentDao;
import com.cwcoffee.springcloud.entity.Payment;
import com.cwcoffee.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author cw
 * @Date 2020/06/28 13:34
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
