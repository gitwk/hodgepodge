package com.wk.bodgepodge.interfaces;

/**
 * @author wangkai
 * @since JDK8
 */
public interface OrderProvider {
    void createOrder(int userId, String commodityCode, int num);
}
