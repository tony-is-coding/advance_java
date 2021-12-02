package com.cnc.my.spring.spring_aop.my_custom;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
    void before();

    void after();

    Object around(JoinPoint joinPoint) throws InvocationTargetException, IllegalAccessException;

    void afterReturning();

    void afterThrowing();
}
