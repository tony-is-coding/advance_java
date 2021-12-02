package com.cnc.my.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackages = "com.cnc.my.spring")
@Configuration
@ImportResource(locations = "classpath:log4j.properties")
public class SpringApplicationConfig {
}
