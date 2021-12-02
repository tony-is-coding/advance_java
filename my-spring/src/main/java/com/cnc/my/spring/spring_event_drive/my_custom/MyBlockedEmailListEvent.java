package com.cnc.my.spring.spring_event_drive.my_custom;

import com.cnc.my.spring.spring_event_drive.my_custom.core.Event;

public class MyBlockedEmailListEvent implements Event {
    private String address;
    private String content;

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }

    public MyBlockedEmailListEvent(String address, String content) {
        this.address = address;
        this.content = content;
    }
}
