package com.wk.hodgepodge.account.db;

/**
 * @author wangkai
 * @since JDK8
 */

public class AccountPo {
    private int id;
    private int userId;
    private int money;

    public int getId() {
        return id;
    }

    public AccountPo setId(int id) {
        this.id = id;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public AccountPo setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getMoney() {
        return money;
    }

    public AccountPo setMoney(int money) {
        this.money = money;
        return this;
    }
}
