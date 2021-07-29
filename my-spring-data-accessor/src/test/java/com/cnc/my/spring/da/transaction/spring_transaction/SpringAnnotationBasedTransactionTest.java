package com.cnc.my.spring.da.transaction.spring_transaction;


import com.cnc.my.spring.da.transaction.spring_transaction.config.TransactionalConfig;
import com.cnc.my.spring.da.transaction.spring_transaction.entity.UserBase;
import com.cnc.my.spring.da.transaction.spring_transaction.service.AccountService;
import com.cnc.my.spring.da.transaction.spring_transaction.service.UserBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TransactionalConfig.class})
public class SpringAnnotationBasedTransactionTest {

    @Autowired
    AccountService accountService;

    @Autowired
    UserBaseService userBaseService;

    @Test
    public void testTransfer() {
        accountService.transfer(2, 1, BigDecimal.valueOf(50));
    }

    @Test
    public void testQueryBasedOnJDBCTemplate() {
        UserBase user = userBaseService.getUserById(3);
        System.out.println(user.toString());
    }

    /**
     * TODO:
     * 1. 测试事务隔离级别关系
     * 2. 测试只读事务作用
     * 3. 测试事务读写异常: 脏读、不可重复读、幻读
     */

}
