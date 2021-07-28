package com.cnc.my.spring.da.transaction.spring_transaction.service.impl;

import com.cnc.my.spring.da.transaction.spring_transaction.dao.AccountDao;
import com.cnc.my.spring.da.transaction.spring_transaction.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
/* 当@Transactional 注解使用在方法时, 需要确保注解注释的方法是`public`的, Transactional 对方法可见性具有一定要求, 如果需要对受保护的方法赋予事务特性, 可以考虑使用基于AspectJ的编织 */
/* @Transactional 注解建议使用在具体的类或者具体的类的方法上, 不建议使用在接口和接口方法上 */
/* spring事务默认的代理模式下, @Transaction 代理对象内的方法调用代理对象内的另一个方法,被调用的方法不再具有事务特性;[不支持自调用], 如果需要考虑自调用,可以采用AspectJ编织 */
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
