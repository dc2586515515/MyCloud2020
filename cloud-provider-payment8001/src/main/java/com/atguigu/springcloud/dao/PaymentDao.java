package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author DC
 * @Date 2020-09-25
 */
@Mapper
public interface PaymentDao {
    public int create(@Param("vo") Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
