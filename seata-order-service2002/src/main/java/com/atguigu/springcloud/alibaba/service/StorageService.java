package com.atguigu.springcloud.alibaba.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author DC
 * @Date 2020-12-07
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}
