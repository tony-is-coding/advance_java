package com.cnc.spring.amqp.rabbitmq;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SenderTest {

    @Test
    public void testPublishConfirm() {
        ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
    }
}