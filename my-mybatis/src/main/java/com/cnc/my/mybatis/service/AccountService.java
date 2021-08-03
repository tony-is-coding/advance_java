package com.cnc.my.mybatis.service;

import com.cnc.my.mybatis.entity.Account;

import java.math.BigDecimal;

public interface AccountService extends IBatisService{

    Account getById(Integer accountId);

    void transfer(Integer fromUser, Integer toUser, BigDecimal amount);
}
