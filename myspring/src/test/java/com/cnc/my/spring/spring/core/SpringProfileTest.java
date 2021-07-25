package com.cnc.my.spring.spring.core;


import com.cnc.my.spring.Application;
import com.cnc.my.spring.profile_annotation.ProfileBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = Application.class)
//@ActiveProfiles("prod")
public class SpringProfileTest {
    @Autowired
    ProfileBean profileBean;

    @Test
    public void testProfile() {
        System.out.println(profileBean.getName());
    }
}
