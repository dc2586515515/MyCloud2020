package com.atguigu.springcloud.LoadBalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author DC
 * @Date 2020-10-12
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 服务实例坐标
     *
     * @return
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next)); //第一个参数是期望值，第二个参数是修改值是
        System.out.println("*******第几次访问，次数next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) { // 得到服务实例列表
        int index = getAndIncrement() % serviceInstances.size(); // 获得服务实例列表下标
        return serviceInstances.get(index); // 返回选择的服务实例
    }
}
