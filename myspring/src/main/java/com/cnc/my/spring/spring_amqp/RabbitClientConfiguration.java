package com.cnc.my.spring.spring_amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitClientConfiguration extends AbstractAppRabbitConfiguration {

    public static final String queue = "com.cnc.spring.queue";

    public static final String exchange = "com.cnc.spring.exchange";

    public static final String routingKey = "com.cnc.spring.routing-key";

    public static final String bindingKey = "com.cnc.spring.routing-key";

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

