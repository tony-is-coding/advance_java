package com.cnc.my.spring.spring_amqp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {AppConfig.class})
public class SenderTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void testSender() {
        Sender sender = context.getBean(Sender.class);
        sender.sendToVacation(RabbitClientConfiguration.queue, "hello world");
    }
}