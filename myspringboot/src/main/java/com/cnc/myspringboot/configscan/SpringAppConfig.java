package com.cnc.myspringboot.configscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.cnc.myspringboot")
@PropertySource("classpath:/properties.properties")
public class SpringAppConfig {
}
