package com.cnc.my.spring.da.transaction.spring_transaction.dao.impl;

import com.cnc.my.spring.da.transaction.spring_transaction.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.math.BigDecimal;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void increment(Integer account, BigDecimal amount) {
        this.getJdbcTemplate().update("update account set amount = amount + ? where account_id = ?", amount, account);
    }

    @Override
    public void decrement(Integer account, BigDecimal amount) {
        this.getJdbcTemplate().update("update account set amount = amount - ? where account_id = ?", amount, account);
    }
}
