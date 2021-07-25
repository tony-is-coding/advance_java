package com.cnc.my.spring.spring.testing;

import com.cnc.my.spring.spring_test.TestingAppConfig;
import com.cnc.my.spring.spring_test.beans.TestingBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {TestingAppConfig.class})
public class SpringTestingAnnotationTest {

    @Test
    public void testContextConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestingAppConfig.class);
        TestingBean testingBean = context.getBean(TestingBean.class);
        testingBean.sayName();
    }
}
