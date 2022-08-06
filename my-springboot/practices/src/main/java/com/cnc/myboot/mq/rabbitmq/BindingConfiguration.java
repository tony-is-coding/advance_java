package com.cnc.myboot.mq.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BindingConfiguration {


    public static final String VACATION_QUEUE = "com.cnc.spring.queue";

    public static final String VACATION_EXCHANGE = "com.cnc.spring.exchange";

    public static final String VACATION_BINDING_KEY = "com.cnc.spring.routing-key";

    final RabbitAdmin rabbitAdmin;

    public BindingConfiguration(RabbitAdmin rabbitAdmin) {
        this.rabbitAdmin = rabbitAdmin;
    }

    @Bean
    public Binding vacationExchangeQueueBind() {
        System.out.println("绑定 vacation exchange queue");
        Queue vacationQueue = new Queue(BindingConfiguration.VACATION_QUEUE);
        DirectExchange vacationExchange = new DirectExchange(VACATION_EXCHANGE);
        rabbitAdmin.declareExchange(vacationExchange);
        rabbitAdmin.declareQueue(vacationQueue);
        return BindingBuilder.bind(vacationQueue).to(vacationExchange).with(VACATION_BINDING_KEY);
    }

}
