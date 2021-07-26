package com.cnc.my.spring.spring_amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/7/17 8:39 下午
 */
@Component
public class Receiver {

    @RabbitListener(queues = {"vacationQueue"})
    public void myQueueListener(String data) {
        System.out.println(data);
    }

}
