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
import java.util.Random;

/**
 * @author wangkai
 * @since JDK8
 */
@Component
@Service
public class AccountProviderImpl implements AccountProvider {

    private static Logger logger = LoggerFactory.getLogger(AccountProviderImpl.class);

    private Random random = new Random();

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(int userId, int money) {
        String xid = RootContext.getXID();
        logger.info("开始执行扣除资金账户操作，全局事务ID为{}", xid);
        AccountPo accountPo = new AccountPo().setUserId(userId).setMoney(money);
        accountMapper.update(accountPo);
        boolean success = random.nextBoolean();
        if (!success) {
            throw new RuntimeException("执行扣除资金账户失败");
        }
        logger.info("执行扣除资金账户操作成功！");
    }

}
