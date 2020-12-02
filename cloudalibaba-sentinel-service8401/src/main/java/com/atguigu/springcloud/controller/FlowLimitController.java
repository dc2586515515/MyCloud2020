package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
        log.info(Thread.currentThread().getName() + "—testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "—testB");
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
        log.info("testD 测试慢调用比例");
        return "------testD";
    }

    /**
     * sentinel降级测试——异常比例
     *
     * @return
     */
    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常比例");
        int age = 10 / 0;
        return "------testE";
    }

    /**
     * sentinel降级测试——异常数
     *
     * @return
     */
    @GetMapping("/testF")
    public String testF() {
        log.info("testF 测试异常数");
        int age = 10 / 0;
        return "------testF 测试异常数";
    }

    /**
     * 测试热点 Key
     *
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        //int age = 10/0;
        return "------testHotKey";
    }

    /**
     * 兜底方法
     *
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "------deal_testHotKey,o(╥﹏╥)o";
    }


}
