package com.cnc.myspringboot.configbean;

import com.cnc.myspringboot.beans.TestBeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeansConfig {

    @Bean
    public TestBeanOne beanOne1() {
        return new TestBeanOne("bean11", 11);
    }

    @Bean
    @Primary
    public TestBeanOne beanOne2() {
        return new TestBeanOne("bean22", 22);
    }
}
