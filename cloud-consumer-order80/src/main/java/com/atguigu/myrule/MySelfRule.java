package com.atguigu.myrule;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 配置类不能放到 @ComponentScan所扫描的当前包以及子包下
 * 否则我们自定义的配置类就会被所有的ribbon客户端所共享，达不到特殊化定制的目的了。
 * @Author DC
 * @Date 2020-10-10
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule(); //负载均衡模式定义为随机
        // return new RoundRobinRule(); // 轮询
        // return new WeightedResponseTimeRule(); // 对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择
        // return new RetryRule(); // 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试
        // return new BestAvailableRule(); // 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
        // return new AvailabilityFilteringRule(); // 先过滤掉故障实例，再选择并发较小的实例
        // return new ZoneAvoidanceRule(); // 默认规则，复合判断server所在区域的性能和server的可用性选择服务器
    }
}
