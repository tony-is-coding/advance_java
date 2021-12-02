package com.cnc.my.spring.spring_aop.my_custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JoinPoint {
    private final Method method;
    private final Object target;
    private final Object[] params;

    public JoinPoint(Object target, Method method, Object[] params) {
        this.method = method;
        this.target = target;
        this.params = params;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }
}
