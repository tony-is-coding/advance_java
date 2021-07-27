package com.cnc.my.spring.da.transaction.spring_transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlBasedTransactionTest {
    @Test
    public void testXmlBasedTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }
}
