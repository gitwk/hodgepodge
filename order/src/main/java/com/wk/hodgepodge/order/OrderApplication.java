package com.wk.hodgepodge.order;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.wk.hodgepodge.order.mapper.OrderMapper;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author wangkai
 * @since JDK8
 */
@EnableDubbo
@NacosPropertySource(dataId = "order.properties", groupId = "hodgepodge.group", autoRefreshed = true)
@MapperScan(basePackages = "com.wk.hodgepodge.order.mapper")
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OrderApplication.class, args);

        OrderMapper orderMapper = applicationContext.getBean(OrderMapper.class);
        orderMapper.clear();

        Logger logger = LoggerFactory.getLogger(OrderApplication.class);
        logger.info("OrderApplication start finished...");
    }
}
