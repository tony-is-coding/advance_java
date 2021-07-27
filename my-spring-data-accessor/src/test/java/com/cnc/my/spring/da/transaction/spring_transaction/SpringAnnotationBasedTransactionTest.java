package com.cnc.my.spring.da.transaction.spring_transaction;


import com.cnc.my.spring.da.transaction.spring_transaction.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringAnnotationBasedTransactionTest {

    @Autowired
    AccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer(2, 1, BigDecimal.valueOf(50));
    }
}
