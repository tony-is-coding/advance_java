package com.cnc.my.spring.spring_event_drive.my;

import com.cnc.my.spring.spring_event_drive.my.core.Listener;

public class MyBlockedEmailNotifier implements Listener<MyBlockedEmailListEvent> {

    @Override
    public void onEventHappened(MyBlockedEmailListEvent event) {
        System.out.println("received a block email event!!!");
        System.out.printf("email [%s] is in block email list, the content: [%s] . may not be send!!!", event.getAddress(), event.getContent());
    }
}
