package com.cnc.spring.beans;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CustomLifecycleBeanTest {
    @Test
    public void testBeanInitial() {
        System.out.println("准备获取应用上下文");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
        System.out.println("成功获取应用上下文");
        CustomInitialBean bean = (CustomInitialBean) context.getBean("initialBean");
    }

    @Test
    public void testBeanDestroy() {
        System.out.println("准备获取应用上下文");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
        System.out.println("成功获取应用上下文");
        CustomDestroyBean bean = (CustomDestroyBean) context.getBean("destroyBean");
        context.close();
    }
}