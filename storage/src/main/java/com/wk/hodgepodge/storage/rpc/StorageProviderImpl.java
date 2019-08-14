package com.wk.hodgepodge.storage.rpc;

import com.wk.bodgepodge.interfaces.StorageProvider;
import com.wk.hodgepodge.storage.mapper.StorageMapper;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author wangkai
 * @since JDK8
 */
@Component
@Service
public class StorageProviderImpl implements StorageProvider {

    private static Logger logger = LoggerFactory.getLogger(StorageMapper.class);

    private Random random = new Random();

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(String commodityCode, int count) {
        String xid = RootContext.getXID();
        logger.info("开始执行扣减库存请求，全局事务ID为{}", xid);
        storageMapper.decrease(commodityCode, count);
        boolean success = random.nextBoolean();
//        if (!success) {
//            throw new RuntimeException("执行扣除库存失败");
//        }
        logger.info("执行扣减库存操作成功！");
    }

}
