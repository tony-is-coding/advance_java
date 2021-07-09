package com.cnc.amqp.rabbitmq;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {
    public static void main(String[] args) {

        try {
            Connection connection = Config.getConnection();
            Channel ch = connection.createChannel();
            ch.basicConsume(Config.queue, true, new DefaultConsumer(ch) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    super.handleDelivery(consumerTag, envelope, properties, body);
                }
            });
        } catch (IOException | TimeoutException e) {
            System.out.println("连接错误: " + e.getMessage());
            return;
        }
    }
}
