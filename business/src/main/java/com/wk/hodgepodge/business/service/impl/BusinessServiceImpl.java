package com.wk.hodgepodge.business.service.impl;

import com.wk.bodgepodge.interfaces.OrderProvider;
import com.wk.bodgepodge.interfaces.StorageProvider;
import com.wk.hodgepodge.business.service.BusinessService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author wangkai
 * @since JDK8
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private static Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);

    @Reference
    private OrderProvider orderProvider;
    @Reference
    private StorageProvider storageProvider;

    @GlobalTransactional
    @Override
    public void createOrder(int userId, String commodityCode, int count, int money) {
        String xid = RootContext.getXID();
        logger.info("开启全局事务ID为{}", xid);
        storageProvider.decrease(commodityCode, count);

        orderProvider.createOrder(userId, commodityCode, count, money);
    }

}
