package com.cnc.myspringboot.container_extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    @SuppressWarnings(" NullableProblems")
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before bean initialize");
        return bean;
    }

    @Override
    @SuppressWarnings(" NullableProblems")
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after bean initialize");
        return bean;
    }
}
