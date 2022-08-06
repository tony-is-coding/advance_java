package com.cnc.myboot.repository.impl;

import com.cnc.myboot.entity.Account;
import com.cnc.myboot.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public List<Account> queryAll() {
        return null;
    }

    @Override
    public void transfer(Account from, Account to, BigDecimal amount) {

    }
}
