package com.cnc.myspringboot.beans;

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
