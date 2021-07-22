package com.cnc.myspringboot.spring_event_drive;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationNotifier {

    @EventListener
    public void handleBlockedEmailList(BlockedEmailListEvent event) {
        System.out.println("\n\n\n [annotation] received a block email event!!!");
        System.out.printf("[annotation] email [%s] is in block email list, the content: [%s] . may not be send!!! \n\n\n", event.getAddress(), event.getContent());
    }

}
