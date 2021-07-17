package com.cnc.amqp.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class Receiver {
    private static final Logger log = Logger.getLogger(Receiver.class.getName());

    public static void main(String[] args) {
        try {
//            Config.initial();
            Connection connection = Config.getConnection();
            Channel channel = connection.createChannel();

            Channel channel1 = connection.createChannel();
            Channel channel2 = connection.createChannel();

            log.info("消费者一开始监听消息...");
            channel.basicConsume(Config.queue, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    log.info("执行线程:" + Thread.currentThread().getName() + " 消费者一收到一条消息, 消息内容是:" + new String(body) + ", 时间:" + System.currentTimeMillis());
                }

            });


            log.info("消费者二开始监听消息...");
            channel.basicConsume(Config.queue, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    log.info("执行线程:" + Thread.currentThread().getName() + "消费者二收到一条消息, 消息内容是:" + new String(body) + ", 时间:" + System.currentTimeMillis());
                }
            });


        } catch (IOException | TimeoutException exception) {
            exception.printStackTrace();
        }
    }
}
