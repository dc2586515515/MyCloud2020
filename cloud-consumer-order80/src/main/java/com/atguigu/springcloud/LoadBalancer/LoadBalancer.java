package com.atguigu.springcloud.LoadBalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description
 * @Author DC
 * @Date 2020-10-13
 */
public interface LoadBalancer {
    //收集服务器总共有多少台能够提供服务的机器，并放到list里面
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
