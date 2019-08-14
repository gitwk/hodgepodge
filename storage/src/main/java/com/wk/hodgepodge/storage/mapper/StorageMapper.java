package com.wk.hodgepodge.storage.mapper;

import com.wk.hodgepodge.storage.db.StoragePo;

/**
 * @author wangkai
 * @since JDK8
 */
public interface StorageMapper {
    void clear();

    void insert(StoragePo storagePo);

    void decrease(int count);
}
