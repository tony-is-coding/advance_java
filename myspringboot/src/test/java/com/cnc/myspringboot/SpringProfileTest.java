package com.cnc.myspringboot;


import com.cnc.myspringboot.profile_annotation.ProfileBean;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


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
