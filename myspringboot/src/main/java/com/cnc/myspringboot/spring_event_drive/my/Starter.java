package com.cnc.myspringboot.spring_event_drive.my;

public class Starter {
    public static void main(String[] args) {
        MyPublisher myPublisher = new MyPublisher();
        myPublisher.addListener(new MyBlockedEmailNotifier());

        MyEmailService service = new MyEmailService();
        service.setEventPublisher(myPublisher);
        service.sendEmail("james", "this is tony");
    }
}
