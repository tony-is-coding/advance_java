package com.cnc.myboot.mq.rabbitmq.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${}", containerFactory = "rabbitMQListenerFactory")
public class Consumer {

    @RabbitHandler
    public void onMessage() {

    }
}
