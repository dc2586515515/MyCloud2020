package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    //成功
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：  " + id + "\t" + "哈哈哈";
    }

    //失败
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")  //3秒钟以内就是正常的业务逻辑
    })
    public String paymentInfo_TimeOut(Integer id) {
        // 上面设置了3秒等待，这里设置延迟5秒，则会走降级方法，
        // 如果设置为3，则可能会走降级，可能不会走降级，因为执行代码需要耗时
        // 如果设置为2，则大概率不会走降级，因为即算执行代码需要耗时，这几行也耗不了2秒，当然不排除网络开销
        int timeNumber = 2;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut,id：  " + id + "\t" + "呜呜呜" + " 耗时(秒)" + timeNumber;
    }

    // 兜底方法
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "    系统繁忙，请稍后再试，id   " + id + "\t" + "哭了哇呜";
    }

}
