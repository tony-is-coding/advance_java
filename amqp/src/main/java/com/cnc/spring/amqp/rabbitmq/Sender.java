package com.cnc.spring.amqp.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/7/17 8:38 下午
 */
@Service
public class Sender {
    @Autowired
    AmqpTemplate amqpTemplate;

    public void send() {

    }
}
