package com.cnc.my.spring.spring.core;

import com.cnc.my.spring.spring_aop.my_custom.HelloService;
import com.cnc.my.spring.spring_aop.my_custom.HelloServiceImpl;
import com.cnc.my.spring.spring_aop.my_custom.InterceptorImpl;
import com.cnc.my.spring.spring_aop.my_custom.ProxyBean;
import org.junit.Test;

public class MyAopTest {
    @Test
    public void testMyAOP() {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService,
                new InterceptorImpl());
        proxy.sayHello("tony tan");


        System.out.println("\n\n ************************* 分割 ************************* \n\n");

        proxy.say("hello world !!!!");
    }
}
