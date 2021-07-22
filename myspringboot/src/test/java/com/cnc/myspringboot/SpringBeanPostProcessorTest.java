package com.cnc.myspringboot;

import com.cnc.myspringboot.configscan.SpringAppConfig;
import com.cnc.myspringboot.container_extension.MyBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanPostProcessorTest {

    @Test
    public void testProcessor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        context.getBean(MyBean.class);

    }
}
