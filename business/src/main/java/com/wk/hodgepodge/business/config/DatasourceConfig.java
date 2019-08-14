package com.wk.hodgepodge.business.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangkai
 * @since JDK8
 */
@Configuration
public class DatasourceConfig {

    @NacosValue("${application.id}")
    private String applicationId;

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner(applicationId, "hodgepodge_tx_group");
    }
}
