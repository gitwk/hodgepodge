package com.wk.hodgepodge.storage.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author wangkai
 * @since JDK8
 */
@Configuration
public class DatasourceConfig {

    @NacosValue("${datasource.jdbcUrl}")
    private String jdbcUrl;
    @NacosValue("${datasource.username}")
    private String username;
    @NacosValue("${datasource.password}")
    private String password;

    @NacosValue("${mybatis.mapper-locations}")
    private String locationPattern;

    @NacosValue("${application.id}")
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
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy());
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources(locationPattern);
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner(applicationId, "hodgepodge-tx-group");
    }

}
