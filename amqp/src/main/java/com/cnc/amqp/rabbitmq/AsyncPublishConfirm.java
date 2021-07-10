package com.cnc.amqp.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import static com.cnc.amqp.rabbitmq.Config.bindingKey;
import static com.cnc.amqp.rabbitmq.Config.exchange;

// 异步的publish confirm 确认
public class AsyncPublishConfirm {
    private static final Logger log = Logger.getLogger(AsyncPublishConfirm.class.getName());

    private static final SortedSet<Long> confirmSet = new ConcurrentSkipListSet<>();

    public static void main(String[] args) {
        final byte[] sendMsg = "send a message to you".getBytes();
        // 同步阻塞式确认, 整体吞吐量会被迫降低
        try {
            Connection connection = Config.getConnection();
            Channel channel = connection.createChannel();
            // 发布确认开启, 代表整个channel 上的所有发送消息都需要确认, channel 会给每个消息打上一个 delivery-tag, 默认从0开始;
            // 通过 tag 来确认消息是否正确的发送到 exchange
            channel.confirmSelect();
            channel.addConfirmListener(new ConfirmListener() {
                @Override
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    log.info("消息: " + deliveryTag + " 发送确认成功..");
                    confirmSet.remove(deliveryTag);
                }

                @Override
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    log.warning("消息: " + deliveryTag + " 发送确认失败,需要重新发送..");
                }
            });

            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .deliveryMode(2) // 消息持久化
                    .build();
            for (int i = 0; i < 200; i++) {
                long deliveryTag = channel.getNextPublishSeqNo();
                channel.basicPublish(exchange, bindingKey, properties, sendMsg);
                confirmSet.add(deliveryTag);
                log.info("消息:" + deliveryTag + "发出...");
            }


        } catch (IOException | TimeoutException e) {
            log.warning("消息发送失败:" + e.getMessage());
        }
    }

}
