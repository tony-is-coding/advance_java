package com.cnc.mp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cnc.mp.entity.Account;
import com.cnc.mp.mapper.AccountMapper;
import com.cnc.mp.service.AccountDaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class AccountDaoServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountDaoService {

    @Override
    @Transactional
    public void transfer(Account from, Account to, BigDecimal amount) {
        from.setAmount(from.getAmount().subtract(amount));
        to.setAmount(to.getAmount().add(amount));
        this.updateBatchById(Arrays.asList(from, to));
    }

    @Override
    public List<Account> listByIds(List<Integer> accountIds) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.in("account_id", accountIds);
        return this.list(wrapper);
    }

}
