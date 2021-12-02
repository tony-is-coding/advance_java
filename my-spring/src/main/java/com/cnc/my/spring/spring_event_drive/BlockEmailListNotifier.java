package com.cnc.my.spring.spring_event_drive;

import org.springframework.context.ApplicationListener;

//@Component
public class BlockEmailListNotifier implements ApplicationListener<BlockedEmailListEvent> {

    @Override
    public void onApplicationEvent(BlockedEmailListEvent event) {
        System.out.println("\n\n\n received a block email event!!!");
        System.out.printf("email [%s] is in block email list, the content: [%s] . may not be send!!! \n\n\n", event.getAddress(), event.getContent());
    }
}
