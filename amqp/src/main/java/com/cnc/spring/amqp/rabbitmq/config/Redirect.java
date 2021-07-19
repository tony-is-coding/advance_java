package com.cnc.spring.amqp.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author tony
 * @desc TODO
 * @createDate 2021/7/17 8:39 下午
 */
@Configuration
public class Redirect {

    private String queue;

    private String exchange;

    private String routingKey;

    private String bindingKey;


    @Bean
    public Queue vacationQueue() {
        return new Queue(queue);
    }

    @Bean
    public DirectExchange vacationExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding vacationExchangeQueueBind(Queue vacationQueue, DirectExchange vacationExchange) {
        return BindingBuilder.bind(vacationQueue).to(vacationExchange).with(bindingKey);
    }

}
