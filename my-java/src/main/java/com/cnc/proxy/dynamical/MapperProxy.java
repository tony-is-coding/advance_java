package com.cnc.proxy.dynamical;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapperProxy implements InvocationHandler {
    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                // 诸如hashCode()、toString()、equals()等方法，将target指向当前对象this
                return method.invoke(this, args);
            } catch (Throwable t) {
            }
        }
        // 投鞭断流
        return new User((Integer) args[0], "zhangsan", 18);
    }
}
