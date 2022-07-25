package com.cnc.mp.service;

import com.cnc.mp.entity.Account;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhiyong.tan
 */
public interface AccountDaoService {

    /**
     *  批量获取账户
     * @param accountIds
     * @return 固定
     */
    List<Account> listAccounts(List<Integer> accountIds);


    /**
     *  事务成功
     * @param from
     * @param to
     * @param amount
     * @return 固定
     */
    Integer updateWithoutTransactional(Account from, Account to, BigDecimal amount);


    /**
     *  事务失败回滚
     * @param from
     * @param to
     * @param amount
     * @return 固定
     * @throws IOException
     */
    Integer transactionRollbackSuccess(Account from, Account to, BigDecimal amount) throws IOException;

    /**
     *  事务失败回滚
     * @param from
     * @param to
     * @param amount
     * @return 固定
     * @throws IOException
     */
    Integer transactionRollbackFailure(Account from, Account to, BigDecimal amount) throws IOException;
}
