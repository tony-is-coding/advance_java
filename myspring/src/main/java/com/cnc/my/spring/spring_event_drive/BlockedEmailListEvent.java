package com.cnc.my.spring.spring_event_drive;

import org.springframework.context.ApplicationEvent;

public class BlockedEmailListEvent extends ApplicationEvent {

    private String address;
    private String content;

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }

    public BlockedEmailListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }
}
