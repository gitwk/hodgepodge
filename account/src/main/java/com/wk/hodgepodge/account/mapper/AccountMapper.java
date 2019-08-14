package com.wk.hodgepodge.account.mapper;

import com.wk.hodgepodge.account.db.AccountPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangkai
 * @since JDK8
 */
public interface AccountMapper {
    void clear();

    void insert(AccountPo accountPo);

    void update(AccountPo accountPo);
}
