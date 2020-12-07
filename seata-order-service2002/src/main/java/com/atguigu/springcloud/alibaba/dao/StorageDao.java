package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author DC
 * @Date 2020-12-07
 */
@Mapper
public interface StorageDao {
    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
