package com.cnc.my.spring.myaop;

import java.lang.reflect.InvocationTargetException;

public class InterceptorImpl implements Interceptor {

    @Override
    public void before() {
        System.out.println("before invocation...");
    }

    @Override
    public void after() {
        System.out.println("after invocation...");
    }

    @Override
    public Object around(JoinPoint joinPoint) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before around...");
        Object ret = joinPoint.proceed();
        System.out.println("after around");
        return ret;
    }

    @Override
    public void afterReturning() {
        System.out.println("after returning...");
    }

    @Override
    public void afterThrowing() {
        System.out.println("after throwing...");
    }
}
