package com.cnc.spring.amqp.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/7/17 8:38 下午
 */
@Component
public class Sender {
    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendToVacation(String routingKey, String message) {
        amqpTemplate.convertAndSend(routingKey, message);
    }
}
