package com.cnc.my.spring.spring_aop;

import org.springframework.stereotype.Service;

@Service
public class AspectWrappedBean{
    public void noException() {
        System.out.println("anything is normal !!!!");
    }
    public void somethingWrong() {
        System.out.println("something exception happened!!!");
    }
}
