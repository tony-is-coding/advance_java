package com.cnc.amqp.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import static com.cnc.amqp.rabbitmq.Config.*;

// 串行发布确认
public class SequencePublishConfirm {
    private static final Logger log = Logger.getLogger(SequencePublishConfirm.class.getName());

    public static void main(String[] args) {
        initial();
        final byte[] sendMsg = "send a message to you".getBytes();

        // 同步阻塞式确认, 整体吞吐量会被迫降低
        try {
            Connection connection = Config.getConnection();
            Channel channel = connection.createChannel();
            // 发布确认开启, 代表整个channel 上的所有发送消息都需要确认, channel 会给每个消息打上一个 delivery-tag, 默认从0开始;
            // 通过 tag 来确认消息是否正确的发送到 exchange
            channel.confirmSelect();
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .deliveryMode(2) // 消息持久化
                    .build();
            channel.basicPublish(exchange + "fail", bindingKey, properties, sendMsg);
            if (!channel.waitForConfirms()) {
                log.warning("消息发送确认失败");
                return;
            }
            log.info("消息发送成功并确认");

        } catch (IOException | TimeoutException | InterruptedException e) {
            log.warning("消息发送失败:" + e.getMessage());
        }
    }
}
