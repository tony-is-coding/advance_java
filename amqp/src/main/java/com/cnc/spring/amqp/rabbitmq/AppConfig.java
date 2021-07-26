package com.cnc.spring.amqp.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.cnc.*")
public class AppConfig {

    @Bean
    public ConnectionFactory amqpConnectionFactory() {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

        connectionFactory.setAddresses("114.67.81.63:5680");

        connectionFactory.setUsername("guest");

        connectionFactory.setPassword("guest");

        connectionFactory.setVirtualHost("/");

        connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CHANNEL);

        connectionFactory.setChannelCacheSize(25);

        connectionFactory.setChannelCheckoutTimeout(0);

        connectionFactory.setPublisherReturns(false);

        return connectionFactory;

    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory amqpConnectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate();

        rabbitTemplate.setConnectionFactory(amqpConnectionFactory);

        rabbitTemplate.setChannelTransacted(false);

        rabbitTemplate.setMandatory(false);

        return rabbitTemplate;

    }

    //    @Value()
    public static final String queue = "com.cnc.spring.queue";

    //    @Value()
    public static final String exchange = "com.cnc.spring.exchange";

    //    @Value()
    public static final String routingKey = "com.cnc.spring.binding-key";

    //    @Value()
    public static final String bindingKey = "com.cnc.spring.binding-key";


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
