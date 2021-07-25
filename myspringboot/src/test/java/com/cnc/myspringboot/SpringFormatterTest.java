package com.cnc.myspringboot;

import com.cnc.myspringboot.beans.DateTimeFormatterBean;
import com.cnc.myspringboot.configscan.SpringAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class SpringFormatterTest {

    @Test
    public void testSpringDateTimeFormat() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        System.out.println(LocalDateTime.now());
        DateTimeFormatterBean bean = context.getBean(DateTimeFormatterBean.class);
        System.out.println(bean.getDate());
        System.out.println(bean.getDateTime());
        System.out.println(bean.getTime());
    }
}
