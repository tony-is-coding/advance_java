package com.cnc.my.spring.spring.core;

import com.cnc.my.spring.beans.ParamGreediestBean;
import com.cnc.my.spring.beans.TestBeanOne;
import com.cnc.my.spring.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
class SpringBeansTests {

    @Autowired
    @Qualifier(value = "beanOne1")
    TestBeanOne beanOne;

    @Resource
    ParamGreediestBean paramGreediestBean;

    @Test
    public void testPrimaryBean() {
        // 标注有 @Primary 的 bean 在选择时会具有更高优先级
        System.out.println(beanOne.toString());
    }

    @Test
    public void testQualifier() {
        // @Qualifier 的优先级 高于 @Primary ;
        System.out.println(beanOne.toString());
    }

    @Test
    public void testGreediestBean() {
        // 默认的bean 注入会依据配置 @Beans 的方法参数最多的工厂方法进行创建bean;
        // 注意这个贪婪规则不适用于 Bean对象 构造方法
        System.out.println(paramGreediestBean.getDesc());
    }

}
