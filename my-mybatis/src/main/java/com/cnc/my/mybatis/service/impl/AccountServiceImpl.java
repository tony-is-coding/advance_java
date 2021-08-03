package com.cnc.my.mybatis.service.impl;

import com.cnc.my.mybatis.entity.Account;
import com.cnc.my.mybatis.mapper.AccountMapper;
import com.cnc.my.mybatis.service.AccountService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private SqlSession session;

    @Override
    public Account getById(Integer accountId) {
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        return mapper.findByAccountId(accountId);
    }

    @Override
    public void transfer(Integer fromUser, Integer toUser, BigDecimal amount) {

    }

    @Override
    public void setSession(SqlSession session) {
        this.session = session;
    }
}
