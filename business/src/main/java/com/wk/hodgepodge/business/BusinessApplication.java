package com.wk.hodgepodge.business;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangkai
 * @since JDK8
 */
@EnableDubbo
@NacosPropertySource(dataId = "business.properties", groupId = "hodgepodge.group", autoRefreshed = true)
@SpringBootApplication
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
