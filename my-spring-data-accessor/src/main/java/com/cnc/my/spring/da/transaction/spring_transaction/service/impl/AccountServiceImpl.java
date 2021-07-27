package com.cnc.my.spring.da.transaction.spring_transaction.service.impl;

import com.cnc.my.spring.da.transaction.spring_transaction.dao.AccountDao;
import com.cnc.my.spring.da.transaction.spring_transaction.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, timeout = -1, isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(Integer fromAccount, Integer toAccount, BigDecimal amount) {
        accountDao.decrement(fromAccount, amount);
        int res = 1 / 0;
        accountDao.increment(toAccount, amount);
    }

}
