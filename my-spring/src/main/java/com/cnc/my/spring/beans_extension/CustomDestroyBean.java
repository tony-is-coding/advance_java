package com.cnc.my.spring.beans_extension;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component("destroyBean")
public class CustomDestroyBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("bean has destroy");
    }

}
