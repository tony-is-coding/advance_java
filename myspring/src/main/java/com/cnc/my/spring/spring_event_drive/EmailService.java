package com.cnc.my.spring.spring_event_drive;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.Arrays;
import java.util.List;

public class EmailService implements ApplicationEventPublisherAware {

    private final List<String> blockedList = Arrays.asList("hello", "world", "this", "is", "tony");
    private ApplicationEventPublisher publisher;


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String content) {
        if (blockedList.contains(address)) {
            publisher.publishEvent(new BlockedEmailListEvent(this, address, content)); // 邮箱冻结处理事件
            return;
        }
        System.out.printf("send a email to [%s], email content is: [%s]", address, content);
    }
}
