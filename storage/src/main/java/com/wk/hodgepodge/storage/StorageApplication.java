package com.wk.hodgepodge.storage;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.wk.hodgepodge.storage.db.StoragePo;
import com.wk.hodgepodge.storage.mapper.StorageMapper;
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
@MapperScan(basePackages = "com.wk.hodgepodge.storage.mapper")
@EnableDubbo
@NacosPropertySource(dataId = "storage.properties",groupId = "hodgepodge.group", autoRefreshed = true)
@SpringBootApplication
public class StorageApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(StorageApplication.class, args);
        StorageMapper storageMapper = applicationContext.getBean(StorageMapper.class);

        storageMapper.clear();
        StoragePo storagePo = new StoragePo().setCommodityCode("goods1").setCount(10);
        storageMapper.insert(storagePo);

        Logger logger = LoggerFactory.getLogger(StorageApplication.class);
        logger.info("StorageApplication start finished...");
    }
}
