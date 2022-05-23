package com.cnc.amqp.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class Config {
    private static final Logger log = Logger.getLogger(Config.class.getName());


    private static final String host = "114.67.81.63";

    private static final int port = 5680;

    private static final String username = "guest";

    private static final String password = "guest";

    public static final String exchange = "com.cnc.tony.exchange";

    public static final String DLXExchange = "com.cnc.tony.dlx.exchange";

    public static final String queue = "com.cnc.tony.queue";

    public static final String DLXQueue = "com.cnc.tony.dlx.queue";

    public static final String bindingKey = "com.cnc.tony.bindingKey";

    public static final String routingKey = "com.cnc.tony.routingKey";

    public static final String DLXBindingKey = bindingKey;

    public static final String DLXRoutingKey = "com.cnc.tony.dlx.routingKey";


    public static void initial() {
        try {
            Connection connection = getConnection();
            Channel channel = connection.createChannel();
            // 死信交换器 与 队列声明
            channel.exchangeDeclare(DLXExchange, BuiltinExchangeType.DIRECT, false);
            channel.queueDeclare(DLXQueue, true, false, true, new HashMap<>());
            channel.queueBind(DLXQueue, DLXExchange, DLXBindingKey);

            // 基础交换器 与 队列声明
            HashMap<String, Object> queueArg = new HashMap<>();
            queueArg.put("x-dead-letter-exchange",DLXExchange);
            channel.queueDeclare(queue, true, false, false,queueArg);
            channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT, true);
            channel.queueBind(queue, exchange, bindingKey);

            log.info("初始化交换机-队列完成...");
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException exception) {
            log.warning("初始化错误:" + exception.getMessage());
            exception.printStackTrace();
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

    public static void main(String[] args) {
        initial();
    }

}
