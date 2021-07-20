package com.cnc.amqp.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import static com.cnc.amqp.rabbitmq.Config.bindingKey;
import static com.cnc.amqp.rabbitmq.Config.exchange;

// 批量进行发布消息确认, 减轻每次发送等待确认压力, 提升吞吐量
public class BatchPublishConfirm {

    private static final Logger log = Logger.getLogger(BatchPublishConfirm.class.getName());

    private static final AtomicInteger batchCounter = new AtomicInteger();

    private static final int BATCH_COUNT = 50;
    private static final List<String> msgCache = new LinkedList<>();

    public static void main(String[] args) {
//        initial();
        final byte[] sendMsg = "send a message to you".getBytes();

        // 这种批量确认的方式可能需要引入多线程管理和本地消息缓冲队列, 带来了一定的代码复杂度
        try {
            Connection connection = Config.getConnection();
            Channel channel = connection.createChannel();
            // 发布确认开启, 代表整个channel 上的所有发送消息都需要确认, channel 会给每个消息打上一个 delivery-tag, 默认从0开始;
            // 通过 tag 来确认消息是否正确的发送到 exchange
            channel.confirmSelect();
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .deliveryMode(2) // 消息持久化
                    .build();
            for (int i = 0; i <= 200; i++) {
                channel.basicPublish(exchange, bindingKey, properties, sendMsg);
                // 此处将消息放入本地缓存表中
                msgCache.add(new String(sendMsg));
                while (batchCounter.incrementAndGet() >= BATCH_COUNT) {
                    batchCounter.set(0);
                    try {
                        if (channel.waitForConfirms()) {
                            msgCache.clear();
                            log.info("批量消息确认成功");
                        }
                    } catch (InterruptedException e) {
                        log.warning("批量消息确认失败...");
                        // 缓冲重放消息
                        // 重放后清空队列
                        msgCache.clear();
                    }

                }
            }
        } catch (IOException | TimeoutException e) {
            log.warning("消息发送失败:" + e.getMessage());
        }
    }
}
