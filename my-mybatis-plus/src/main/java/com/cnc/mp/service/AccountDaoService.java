package com.cnc.mp.service;

import com.cnc.mp.entity.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDaoService {
    void transfer(Account from, Account to, BigDecimal amount);

    List<Account> listByIds(List<Integer> accountIds);
}
