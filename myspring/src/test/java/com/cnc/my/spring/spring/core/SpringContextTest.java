package com.cnc.my.spring.spring.core;

import com.cnc.my.spring.beans.TestBeanOne;
import com.cnc.my.spring.configbean.BeansConfig;
import com.cnc.my.spring.beans.ComponentBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextTest {
    @Test
    public void testConfigContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        TestBeanOne beanOne = context.getBean(TestBeanOne.class);
        System.out.println(beanOne.toString());
    }

    @Test
    public void testComponentContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentBean.class);
        ComponentBean bean = context.getBean(ComponentBean.class);
        bean.say();
    }
}
