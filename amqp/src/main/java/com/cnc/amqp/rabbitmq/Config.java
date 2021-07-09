package com.cnc.amqp.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class Config {

    private static final String host = "rabbitmq-dev.2haohr.com";

    private static final int port = 5672;

    private static final String username = "guest";

    private static final String password = "guest";

    public static final String exchange = "com.cnc.tony.exchange";

    public static final String queue = "com.cnc.tony.queue";

    public static final String bindKey = "com.cnc.tony.bind-key";

    static {

        try {
            Connection connection = getConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(queue, false, false, false, new HashMap<>());
            channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT, false);
            channel.queueBind(queue, exchange, bindKey);

            channel.close();
            connection.close();
        } catch (IOException | TimeoutException exception) {
            System.out.println("连接错误: " + exception.getMessage());
        }
    }


    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        return factory.newConnection();
    }

}
