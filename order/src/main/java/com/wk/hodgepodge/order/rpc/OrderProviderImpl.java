package com.wk.hodgepodge.order.rpc;

import com.wk.bodgepodge.interfaces.AccountProvider;
import com.wk.bodgepodge.interfaces.OrderProvider;
import com.wk.hodgepodge.order.db.OrderPo;
import com.wk.hodgepodge.order.mapper.OrderMapper;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wangkai
 * @since JDK8
 */
@Component
@Service
public class OrderProviderImpl implements OrderProvider {

    private static Logger logger = LoggerFactory.getLogger(OrderProviderImpl.class);
    @Resource
    private OrderMapper orderMapper;
    @Reference(check = false)
    private AccountProvider accountProvider;

    @Override
    public void createOrder(int userId, String commodityCode, int count, int money) {
        String xid = RootContext.getXID();
        logger.info("开始执行下单操作，全局事务ID为{}", xid);
        OrderPo orderPo = new OrderPo().setUserId(userId).setCommodityCode(commodityCode).setCount(count).setMoney(money);
        orderMapper.insert(orderPo);

        logger.info("发起调用：扣除账户资金服务");
        accountProvider.decrease(userId, money);
        logger.info("调用扣除账户资金服务成功，执行下单操作成功");
    }

}
