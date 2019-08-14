package com.wk.bodgepodge.interfaces;

/**
 * @author wangkai
 * @since JDK8
 */
public interface AccountProvider {
    void decrease(int userId, int amount);
}
