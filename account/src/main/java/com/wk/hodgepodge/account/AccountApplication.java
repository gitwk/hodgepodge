package com.wk.hodgepodge.account;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.wk.hodgepodge.account.db.AccountPo;
import com.wk.hodgepodge.account.mapper.AccountMapper;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author wangkai
 * @since JDK8
 */
@EnableDubbo
@MapperScan(basePackages = "com.wk.hodgepodge.account.mapper")
@NacosPropertySource(dataId = "account.properties", groupId = "hodgepodge.group", autoRefreshed = true)
@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AccountApplication.class, args);
        AccountMapper accountMapper = applicationContext.getBean(AccountMapper.class);

        accountMapper.clear();
        AccountPo accountPo = new AccountPo().setUserId(1).setMoney(100);
        accountMapper.insert(accountPo);

        Logger logger = LoggerFactory.getLogger(AccountApplication.class);
        logger.info("AccountApplication start finished...");
    }
}
