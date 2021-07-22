package com.cnc.myspringboot.profile_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
public class ProdConfig {
    @Bean
    public ProfileBean profileBean() {
        return new ProfileBean("prod profile");
    }
}
