package com.cnc.myboot.mq.rabbitmq.producer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer implements RabbitTemplate.ReturnCallback {

    //    @Value("${}:xxx")
    private static String exchange = "ssss";

    final RabbitTemplate template;

    public Producer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendToExchange(String routingKey, final Object payload) {
        this.template.convertAndSend(exchange, routingKey, payload);
    }

    public void sendToQueue(String queue, final Object payload) {
        this.template.convertAndSend(queue, payload);
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        // 处理消息返回
    }
}

