package com.cnc.amqp.rabbitmq;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import static com.cnc.amqp.rabbitmq.Config.*;


public class Sender {
    private static final Logger log = Logger.getLogger(Sender.class.getName());

    public static void main(String[] args) {
        initial();
        final byte[] sendMsg = "send a message to you".getBytes();

        try {
            Connection connection = Config.getConnection();
            Channel channel = connection.createChannel();
            channel.basicQos(10);
            channel.addReturnListener((replyCode, replyText, exchange, routingKey, properties, body) -> {
                log.info("消息未被正确的路由到: " + new String(body));
            });
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .deliveryMode(2) // 消息持久化
                    .build();
            channel.basicPublish(exchange, bindingKey, true, properties, sendMsg);

        } catch (IOException | TimeoutException e) {
            log.info("连接错误: " + e.getMessage());
        }
    }
}
