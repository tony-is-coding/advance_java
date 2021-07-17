package com.cnc.spring.amqp.rabbitmq.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @desc TODO
 *
 * @author tony
 * @createDate 2021/7/17 8:39 下午
 */
@Configuration
public class Redirect {

    @Value()
    private String queue;

    @Value()
    private String exchange;

    @Value()
    private String routingKey;

    @Value()
    private String bindingKey;


    @Bean
    public Queue vacationQueue() {
        return new Queue(queue);
    }

    @Bean
    public Exchange vacationExchange() {
        return new DirectExchange(exchange);
    }



}
