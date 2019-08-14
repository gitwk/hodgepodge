package com.wk.hodgepodge.order.rpc;

import com.wk.bodgepodge.interfaces.OrderProvider;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author wangkai
 * @since JDK8
 */
@Component
@Service
public class OrderProviderImpl implements OrderProvider {
    @Override
    public void createOrder(int userId, String commodityCode, int num) {

    }
}
