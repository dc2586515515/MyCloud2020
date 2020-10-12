package com.atguigu.springcloud.LoadBalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description
 * @Author DC
 * @Date 2020-10-12
 */
public interface LoadBalancer {
    // 获取所有可用的服务实例列表
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}