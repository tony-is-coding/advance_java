package com.cnc.myboot.runner;

import com.cnc.myboot.properties.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ExampleApplicationRunner implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(ExampleApplicationRunner.class);

    @Autowired
    ApplicationContext context;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("application runner has executed...");

        try {
            ApplicationProperties appProperties = context.getBean(ApplicationProperties.class);
            System.out.println("start printf the application properties...");
            if (appProperties != null) {
                log.info("app-name:{}; app-version:{}; app-author:{};", appProperties.getName(), appProperties.getVersion(), appProperties.getAuthor());
            }
        } catch (Exception e) {
        }
    }
}
