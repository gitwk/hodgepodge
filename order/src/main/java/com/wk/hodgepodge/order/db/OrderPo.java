package com.wk.hodgepodge.order.db;

/**
 * @author wangkai
 * @since JDK8
 */

public class OrderPo {
    private int id;
    private String commodityCode;
    private int count;
    private int userId;
    private int money;

    public int getId() {
        return id;
    }

    public OrderPo setId(int id) {
        this.id = id;
        return this;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public OrderPo setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
        return this;
    }

    public int getCount() {
        return count;
    }

    public OrderPo setCount(int count) {
        this.count = count;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public OrderPo setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getMoney() {
        return money;
    }

    public OrderPo setMoney(int money) {
        this.money = money;
        return this;
    }
}
