package com.cwcoffee.springcloud.dao;

import com.cwcoffee.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author cw
 * @Date 2020/06/28 11:34
 */
@Mapper
public interface PaymentDao {
    int insert(Payment payment);
    Payment getPaymentById(Long id);
}
