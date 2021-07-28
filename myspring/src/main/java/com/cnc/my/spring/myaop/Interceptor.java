package com.cnc.my.spring.myaop;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
    void before();

    void after();

    Object around(JoinPoint joinPoint) throws InvocationTargetException, IllegalAccessException;

    void afterReturning();

    void afterThrowing();
}
