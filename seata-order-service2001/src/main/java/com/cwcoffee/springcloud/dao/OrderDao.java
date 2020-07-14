package com.cwcoffee.springcloud.dao;

import com.cwcoffee.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author cw
 * @Date 2020/07/14 13:51
 */
@Mapper
public interface OrderDao {
    /**
     * 新建订单
     */
    void create(Order order);

    /**
     * 修改订单状态 从0改为1
     * @param userId
     * @param status
     */
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
