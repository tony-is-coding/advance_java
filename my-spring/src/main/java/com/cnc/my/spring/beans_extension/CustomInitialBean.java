package com.cnc.my.spring.beans_extension;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("initialBean")
public class CustomInitialBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean has initial");
    }
}
