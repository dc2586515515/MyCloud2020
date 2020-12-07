package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.AccountDao;
import com.atguigu.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author DC
 * @Date 2020-12-07
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {

        log.info("------->account-service中扣减账户余额开始");
        // 正常情况
        // accountDao.decrease(userId, money);

        // 模拟超时异常，因为Feign客户端默认超时时间为 1s
        try {
            TimeUnit.SECONDS.sleep(10);
            accountDao.decrease(userId, money);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("------->account-service中扣减账户余额结束");
    }
}
