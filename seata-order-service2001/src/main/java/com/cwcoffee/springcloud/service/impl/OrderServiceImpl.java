package com.cwcoffee.springcloud.service.impl;

import com.cwcoffee.springcloud.dao.OrderDao;
import com.cwcoffee.springcloud.domain.Order;
import com.cwcoffee.springcloud.service.AccountService;
import com.cwcoffee.springcloud.service.OrderService;
import com.cwcoffee.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author cw
 * @Date 2020/07/14 15:03
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    public void create(Order order) {
        log.info("开始创建订单>>>");
        orderDao.create(order);
        log.info("订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("订单微服务开始调用账户，做扣减");

    }
}
