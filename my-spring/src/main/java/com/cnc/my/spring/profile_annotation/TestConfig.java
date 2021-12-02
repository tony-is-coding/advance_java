package com.cnc.my.spring.profile_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Profile("test")
//@Component
public class TestConfig {
    @Bean
    public ProfileBean profileBean() {
        return new ProfileBean("test profile");
    }
}
