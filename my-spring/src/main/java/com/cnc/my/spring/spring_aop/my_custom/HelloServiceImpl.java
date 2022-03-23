package com.cnc.my.spring.spring_aop.my_custom;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        say("Hello, " + name + " !!!");
    }

    @Override
    public void say(String msg) {
        System.out.println(msg);
    }
}
