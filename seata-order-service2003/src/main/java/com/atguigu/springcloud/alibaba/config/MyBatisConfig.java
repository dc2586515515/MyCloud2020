package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author DC
 * @Date 2020-12-07
 */
@Configuration
@MapperScan(value = {"com.atguigu.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
