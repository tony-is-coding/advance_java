package com.cnc.spring.amqp.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author tony
 * @desc TODO
 * @createDate 2021/7/17 8:39 下午
 */
@Configuration
public class Redirect {


    //    @Value()
    private String queue = "com.cnc.spring.queue";

    //    @Value()
    private String exchange = "com.cnc.spring.exchange";

    //    @Value()
    private String routingKey = "com.cnc.spring.binding-key";

    //    @Value()
    private String bindingKey = "com.cnc.spring.binding-key";


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
