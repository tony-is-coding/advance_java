package com.cnc.myspringboot;

import com.cnc.myspringboot.beans.TestBeanOne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
class SpringBeansTests {

    @Autowired
    @Qualifier(value = "beanOne1") // qualifier 的优先级 高于 primary ;
    TestBeanOne beanOne;

    @Test
    public void testPrimaryBean() {
        System.out.println(beanOne.toString());
    }

    @Test
    public void testQualifier() {
        System.out.println(beanOne.toString());
    }

}
