package com.cnc.my.spring.myaop;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("next to say");
        say("Hello, " + name + " !!!");
    }

    @Override
    public void say(String msg) {
        System.out.println(msg);
    }
}
