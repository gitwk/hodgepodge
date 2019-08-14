package com.wk.hodgepodge.storage.db;

/**
 * @author wangkai
 * @since JDK8
 */

public class StoragePo {
    private int id;
    private String commodityCode;
    private int count;

    public int getId() {
        return id;
    }

    public StoragePo setId(int id) {
        this.id = id;
        return this;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public StoragePo setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
        return this;
    }

    public int getCount() {
        return count;
    }

    public StoragePo setCount(int count) {
        this.count = count;
        return this;
    }
}
