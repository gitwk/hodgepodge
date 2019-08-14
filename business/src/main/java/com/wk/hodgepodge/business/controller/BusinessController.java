package com.wk.hodgepodge.business.controller;

import com.wk.hodgepodge.business.service.BusinessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangkai
 * @since JDK8
 */
@RestController
public class BusinessController {

    @Resource
    private BusinessService businessService;

    @PostMapping("order")
    public Object createOrder(int userId, String commodityCode, int count, int money) {
        businessService.createOrder(userId, commodityCode, count, money);
        return "订单创建成功";
    }

}
