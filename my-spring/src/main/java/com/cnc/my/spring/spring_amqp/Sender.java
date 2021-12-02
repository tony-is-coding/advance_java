package com.cnc.my.spring.spring_amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/7/17 8:38 下午
 */
@Component
public class Sender {
    final AmqpTemplate amqpTemplate;

    public Sender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendToVacation(String routingKey, String message) {
        amqpTemplate.convertAndSend(routingKey, message);
    }
}
