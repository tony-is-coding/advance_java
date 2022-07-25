package com.cnc.mp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cnc.mp.entity.Account;
import com.cnc.mp.mapper.AccountMapper;
import com.cnc.mp.service.AccountDaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiyong.tan
 */
@Service
public class AccountDaoServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountDaoService {

    /*
        spring 默认对 RunningTimeException及其子类、Error 两大类进行回滚处理,  但是默认情况下不会对Exception下的RunningTime族外异常处理
        比如SQLException, IOException 之类的受检查异常则需要通过 事务注解`@Transactional` 声明中的 `rollbackFor` 属性来处理了
     */


    @Override
    public List<Account> listAccounts(List<Integer> accountIds) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.in("account_id", accountIds);
        return this.list(wrapper);
    }

    @Override
    public Integer updateWithoutTransactional(Account from, Account to, BigDecimal amount) {
        from.setAmount(from.getAmount().subtract(amount));
        to.setAmount(to.getAmount().add(amount));
        this.updateById(from);
        int a = 0;
        int b = 10;
        int c = b / a;
        this.updateById(to);
        return 100;
    }

    @Override
    @Transactional(rollbackFor = IOException.class)
    public Integer transactionRollbackSuccess(Account from, Account to, BigDecimal amount) throws IOException{
        from.setAmount(from.getAmount().subtract(amount));
        to.setAmount(to.getAmount().add(amount));
        this.updateById(from);
        try{
            int a = 0;
            int b = 10;
            int c = b / a;
        }catch (ArithmeticException e){
            throw new IOException(e.getCause());
        }
        this.updateById(to);
        return 100;
    }

    @Override
    @Transactional(rollbackFor = ArithmeticException.class)
    public Integer transactionRollbackFailure(Account from, Account to, BigDecimal amount) throws IOException{
        from.setAmount(from.getAmount().subtract(amount));
        to.setAmount(to.getAmount().add(amount));
        this.updateById(from);
        try{
            int a = 0;
            int b = 10;
            int c = b / a;
        }catch (ArithmeticException e){
            throw new IOException(e.getCause());
        }
        this.updateById(to);
        return 100;
    }

}
