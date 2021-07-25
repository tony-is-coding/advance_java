package com.cnc.myspringboot.configbean;

import com.cnc.myspringboot.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

@Configuration
@ComponentScans(value = {})
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


    @Bean
    public ParamBeanOne paramBeanOne() {
        return new ParamBeanOne();
    }

    @Bean
    public ParamBeanTwo paramBeanTwo() {
        return new ParamBeanTwo();
    }

    @Bean
    public ParamBeanThree paramBeanThree() {
        return new ParamBeanThree();
    }

    @Bean
    public ParamGreediestBean greediestBean(ParamBeanOne paramBeanOne, ParamBeanTwo paramBeanTwo) {
        return new ParamGreediestBean("one and two");
    }


    @Bean
    public ParamGreediestBean greediestBean(ParamBeanOne paramBeanOne) {
        return new ParamGreediestBean("one");
    }

    @Bean
    public DateTimeFormatterBean dateTimeFormatterBean() {
        LocalDateTime now = LocalDateTime.now();
        return new DateTimeFormatterBean(now.toLocalDate(), now, now.toLocalTime());
    }
}
