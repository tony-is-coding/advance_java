package com.cnc.my.mybatis.mapper;

import com.cnc.my.mybatis.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    Account findByAccountId(Integer accountId);

    Account findByUserId(Integer userId);

    void insert(Account account);
}
