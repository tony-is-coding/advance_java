package com.cnc.my.spring.profile_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Profile("dev")
@Component
public class DevConfig {

    @Bean
    public ProfileBean profileBean() {
        return new ProfileBean("dev profile");
    }
}
