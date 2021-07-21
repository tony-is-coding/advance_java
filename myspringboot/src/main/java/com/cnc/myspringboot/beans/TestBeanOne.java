package com.cnc.myspringboot.beans;

import org.springframework.stereotype.Service;

public class TestBeanOne {

    private String name;
    private int age;

    public TestBeanOne(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestBeanOne{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
