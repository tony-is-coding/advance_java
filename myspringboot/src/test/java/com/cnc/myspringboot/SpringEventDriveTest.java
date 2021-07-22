package com.cnc.myspringboot;

import com.cnc.myspringboot.configscan.SpringAppConfig;
import com.cnc.myspringboot.spring_event_drive.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEventDriveTest {
    @Test
    public void testPublishEmailEvent() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        EmailService emailService = new EmailService();
        emailService.setApplicationEventPublisher(context);
        emailService.sendEmail("tony", "hello this is tony!!!");
    }
}
