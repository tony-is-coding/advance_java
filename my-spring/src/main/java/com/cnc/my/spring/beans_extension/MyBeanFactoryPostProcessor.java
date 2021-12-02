package com.cnc.my.spring.beans_extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * BeanFactoryPostProcessor 实际上是修改了BeanFactory 相关的配置元;
     * 这部分动作 发生在bean 实例化前, 也发生在 BeanPostProcessor 之前
     *
     * BeanFactory 是所有bean 实例化的 代理工厂, BeanFactoryProcessor就是对代理工厂进行前置处理
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("myBean");
        bd.getPropertyValues();
    }
}
