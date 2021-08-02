package com.cnc.myboot.repository;


import com.cnc.myboot.entity.Account;
import org.springframework.data.repository.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends Repository<Account, Long> {

    List<Account> queryAll();

    void transfer(Account from, Account to, BigDecimal amount);
}
