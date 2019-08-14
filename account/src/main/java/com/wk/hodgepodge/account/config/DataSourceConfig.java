package com.wk.hodgepodge.account.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author wangkai
 * @since JDK8
 */
@Configuration
public class DataSourceConfig {

    @NacosValue(value = "${datasource.jdbcUrl}", autoRefreshed = true)
    private String jdbcUrl;
    @NacosValue(value = "${datasource.username}", autoRefreshed = true)
    private String username;
    @NacosValue(value = "${datasource.password}", autoRefreshed = true)
    private String password;

    @NacosValue(value = "${mybatis.mapper-locations}", autoRefreshed = true)
    private String locationPattern;

    @NacosValue(value = "${application.id}", autoRefreshed = true)
    private String applicationId;

    @Bean
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(jdbcUrl);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        return hikariDataSource;
    }

    @Bean
    public DataSourceProxy dataSourceProxy() {
        return new DataSourceProxy(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(locationPattern));
        return sqlSessionFactoryBean;
    }

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner(applicationId, "hodgepodge_tx_group1");
    }
}
