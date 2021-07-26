package com.cnc.spring.amqp.rabbitmq;


import org.junit.Test;
import org.springframework.amqp.core.Binding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SenderTest {

    @Test
    public void testPublishConfirm() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Sender sender = context.getBean(Sender.class);

        Binding vacationExchangeQueueBind = context.getBean(Binding.class);
        sender.sendToVacation(AppConfig.queue, "hello world");
    }
}