package com.cnc.myboot.runner;

import com.cnc.myboot.properties.ApplicationProperties;
import com.cnc.myboot.properties.ThreadPoolProperties;
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
    @Autowired
    ThreadPoolProperties threadPoolProperties;
    @Autowired
    ApplicationProperties applicationProperties;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("\n\n");
        System.out.println(threadPoolProperties);


        System.out.println(applicationProperties);
    }
}
