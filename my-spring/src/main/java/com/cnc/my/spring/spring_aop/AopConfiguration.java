package com.cnc.my.spring.spring_aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * com.cnc.my.spring.spring_aop - AopConfiguration
 *
 * @author tony-is-coding
 * @date 2022/7/4 14:52
 */
@Configuration
@ComponentScan(basePackages = "com.cnc.my.spring.spring_aop")
@EnableAspectJAutoProxy
public class AopConfiguration {
}
