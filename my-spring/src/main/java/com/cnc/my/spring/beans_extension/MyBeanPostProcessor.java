package com.cnc.my.spring.beans_extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    @SuppressWarnings(" NullableProblems")
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before bean initialize : " + beanName);
        return bean;
    }

    @Override
    @SuppressWarnings(" NullableProblems")
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after bean initialize : " + beanName);
        return bean;
    }
}
