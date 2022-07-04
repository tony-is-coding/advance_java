package com.cnc.my.spring.spring_aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * com.cnc.my.spring.spring_aop - AopConfigurationTest
 *
 * @author tony-is-coding
 * @date 2022/7/4 14:53
 */
public class AopConfigurationTest {

    @Test
    public void testSpringAop() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfiguration.class);
        AspectWrappedBean bean = ctx.getBean(AspectWrappedBean.class);
        bean.noException();
    }
}