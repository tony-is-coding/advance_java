package com.cnc.myspringboot.profile_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
public class TestConfig {
    @Bean
    public ProfileBean profileBean() {
        return new ProfileBean("test profile");
    }
}
