package com.cnc.my.spring.spring.testing;

import com.cnc.my.spring.spring_test.TestingAppConfig;
import com.cnc.my.spring.spring_test.beans.TestingBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {TestingAppConfig.class})
public class ContextMangerTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testInjectContext() {
        TestingBean bean = applicationContext.getBean(TestingBean.class);
        bean.sayName();
    }
}
