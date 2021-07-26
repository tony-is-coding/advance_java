package com.cnc.my.spring.da.transaction.spring_transaction;

import com.cnc.my.spring.da.transaction.spring_transaction.service.FooService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXmlBasedTransactionTest {
    @Test
    public void testXmlBasedTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
        FooService fooService = context.getBean(FooService.class);
        fooService.insertFoo(new Foo());
    }
}
