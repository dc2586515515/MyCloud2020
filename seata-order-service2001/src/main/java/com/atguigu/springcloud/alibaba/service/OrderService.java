package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * @Description
 * @Author DC
 * @Date 2020-12-04
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param order
     */
    void create(Order order);
}
