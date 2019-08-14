package com.wk.hodgepodge.business.service;

/**
 * @author wangkai
 * @since JDK8
 */
public interface BusinessService {
    void createOrder(int userId, String commodityCode, int count, int money);
}
