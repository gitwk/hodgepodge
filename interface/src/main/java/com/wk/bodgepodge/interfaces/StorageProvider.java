package com.wk.bodgepodge.interfaces;

/**
 * @author wangkai
 * @since JDK8
 */
public interface StorageProvider {
    void decrease(String commodity, int count);
}
