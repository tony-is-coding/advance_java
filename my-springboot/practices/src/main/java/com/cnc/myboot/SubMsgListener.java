package com.cnc.myboot;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * com.cnc.myboot.myboot - SubMsgListener
 *
 * @author tony-is-coding
 * @date 2022/2/19 19:01
 */
@Component
public class SubMsgListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("收到消息：" + new String(message.getBody()));
    }
}

