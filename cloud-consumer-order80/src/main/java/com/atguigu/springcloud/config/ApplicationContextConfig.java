package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description RestTemplate配置类，将RestTemplate注入Spring容器
 * @Author DC
 * @Date 2020-09-25
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    // @LoadBalanced //根据服务名查找服务实例，并负载均衡调用,服务的发现与负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
