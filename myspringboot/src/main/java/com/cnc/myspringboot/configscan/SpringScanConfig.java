package com.cnc.myspringboot.configscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.cnc.myspringboot")
public class SpringScanConfig {
}
