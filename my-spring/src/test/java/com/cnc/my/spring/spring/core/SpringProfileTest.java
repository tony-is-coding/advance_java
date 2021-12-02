package com.cnc.my.spring.spring.core;


import com.cnc.my.spring.SpringApplicationConfig;
import com.cnc.my.spring.profile_annotation.ProfileBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = {SpringApplicationConfig.class})
public class SpringProfileTest {

    @Autowired
    ProfileBean profileBean;

    @Test
    public void testProfile() {
        System.out.println(profileBean.getName());
    }
}
