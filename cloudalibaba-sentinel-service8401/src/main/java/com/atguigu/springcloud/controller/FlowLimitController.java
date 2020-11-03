package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author DC
 * @Date 2020-11-02
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }


    /**
     * sentinel降级测试——RT
     *
     * @return
     */
    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------testD";
    }

    /**
     * sentinel降级测试——异常比例
     * @return
     */
    @GetMapping("/testE")
    public String testE()
    {
        log.info("testD 测试RT");
        int age = 10/0;
        return "------testE";
    }

    /**
     * sentinel降级测试——异常数
     * @return
     */
    @GetMapping("/testF")
    public String testF()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }


}
