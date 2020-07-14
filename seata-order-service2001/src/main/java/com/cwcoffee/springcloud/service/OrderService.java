package com.cwcoffee.springcloud.service;

import com.cwcoffee.springcloud.domain.Order;

/**
 * @Author cw
 * @Date 2020/07/14 15:02
 */
public interface OrderService {

    void create(Order order);
}
