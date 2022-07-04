package com.cnc.my.spring.beans_extension;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements InitializingBean, DisposableBean {
    public MyBean() {
        System.out.println("bean MyBean initialize");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet: MyBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bean MyBean has destroy");
    }
}
