package com.wk.hodgepodge.account.rpc;

import com.wk.bodgepodge.interfaces.AccountProvider;
import com.wk.hodgepodge.account.db.AccountPo;
import com.wk.hodgepodge.account.mapper.AccountMapper;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wangkai
 * @since JDK8
 */
@Component
@Service
public class AccountProviderImpl implements AccountProvider {

    private static Logger logger = LoggerFactory.getLogger(AccountProviderImpl.class);

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(int userId, int amount) {
        String xid = RootContext.getXID();
        logger.info("开始执行扣除资金账户操作，全局事务ID为{}", xid);
        AccountPo accountPo = new AccountPo().setUserId(userId).setMoney(amount);
        accountMapper.update(accountPo);
        logger.info("执行扣除资金账户操作成功！");
    }

}
