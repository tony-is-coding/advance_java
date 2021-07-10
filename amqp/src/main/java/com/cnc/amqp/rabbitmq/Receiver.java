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

            log.info("消费者开始监听消息...");
            channel.basicConsume(Config.queue, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    log.info("收到一条消息, 消息内容是:" + new String(body) + ", 时间:" + System.currentTimeMillis());
                    log.info("拒绝本次消息...");
                    channel.basicReject(envelope.getDeliveryTag(), false);
                }
            });
        } catch (IOException | TimeoutException exception) {
            exception.printStackTrace();
        }
    }
}
