package com.cnc.amqp.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class DLXReceiver {
    private static final Logger log = Logger.getLogger(DLXReceiver.class.getName());

    public static void main(String[] args) {
        try {
            Config.initial();


            Connection connection = Config.getConnection();
            Channel channel = connection.createChannel();

            log.info("死信消费者开始监听消息...");
            channel.basicConsume(Config.DLXQueue, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    log.info("收到一条死消息, 消息内容是: " + new String(body) + ", 时间:" + System.currentTimeMillis());
                    super.handleDelivery(consumerTag, envelope, properties, body);
                }

            });
        } catch (IOException | TimeoutException exception) {
            exception.printStackTrace();
        }
    }
}
