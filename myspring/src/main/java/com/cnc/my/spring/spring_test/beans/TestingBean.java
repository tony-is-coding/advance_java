package com.cnc.my.spring.spring_test.beans;

import org.springframework.stereotype.Component;

@Component
public class TestingBean {
    public void sayName() {
        System.out.println("hello world!!!");
    }
}
