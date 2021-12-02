package com.cnc.my.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.cnc.my.spring")
@Configuration
@PropertySource("classpath:log4j.properties")
public class SpringApplicationConfig {
}
