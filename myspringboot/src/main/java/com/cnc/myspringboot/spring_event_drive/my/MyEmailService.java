package com.cnc.myspringboot.spring_event_drive.my;

import com.cnc.myspringboot.spring_event_drive.my.core.Publisher;

import java.util.Arrays;
import java.util.List;

public class MyEmailService {
    private final List<String> blockedList = Arrays.asList("hello", "world", "this", "is", "tony");
    private Publisher publisher;

    public void setEventPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String content) {
        if (blockedList.contains(address)) {
            publisher.publish(new MyBlockedEmailListEvent(address, content)); // 邮箱冻结处理事件
            return;
        }
        System.out.println("xxxxx");
        // send email...
    }
}
