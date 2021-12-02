package com.cnc.my.spring.spring.core;

import com.cnc.my.spring.configscan.SpringAppConfig;
import com.cnc.my.spring.spring_aop.AspectWrappedBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAOPTest {
    @Test
    public void testSpringAOP() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        AspectWrappedBean bean = context.getBean(AspectWrappedBean.class);
        System.out.println("\n\n\n\n");
        bean.noException();
        System.out.println("\n\n\n\n");
        bean.somethingWrong();
    }

}

