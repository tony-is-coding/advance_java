package com.cnc.myspringboot.spring_event_drive;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BlockEmailListNotifier implements ApplicationListener<BlockedEmailListEvent> {

    @Override
    public void onApplicationEvent(BlockedEmailListEvent event) {
        System.out.println("received a block email event!!!");
        System.out.printf("email [%s] is in block email list, the content: [%s] . may not be send!!!", event.getAddress(), event.getContent());
    }
}
