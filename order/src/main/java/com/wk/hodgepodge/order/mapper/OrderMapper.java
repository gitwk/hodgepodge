package com.wk.hodgepodge.order.mapper;

import com.wk.hodgepodge.order.db.OrderPo;

/**
 * @author wangkai
 * @since JDK8
 */
public interface OrderMapper {
    void clear();

    void insert(OrderPo orderPo);
}
