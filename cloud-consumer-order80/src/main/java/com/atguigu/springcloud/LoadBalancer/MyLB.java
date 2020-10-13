package com.atguigu.springcloud.LoadBalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author DC
 * @Date 2020-10-13
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * final修饰，集成也不可修改
     *
     * @return
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }
        //采用CAS锁自旋的方式，如果当前current与预期的一致，则更新，如果current被其他线程改变了，
        // 不等与之前之前取得预期值，则重新进行循环，直到current等于上一步取得预期值为止，即，自旋锁（轻量级锁）
        while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*******第几次访问，次数next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
