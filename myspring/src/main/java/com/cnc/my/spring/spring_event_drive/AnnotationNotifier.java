package com.cnc.my.spring.spring_event_drive;


//@Component
public class AnnotationNotifier {

//    @EventListener
    public void handleBlockedEmailList(BlockedEmailListEvent event) {
        System.out.println("\n\n\n [annotation] received a block email event!!!");
        System.out.printf("[annotation] email [%s] is in block email list, the content: [%s] . may not be send!!! \n\n\n", event.getAddress(), event.getContent());
    }

}
