package com.std.anno.base;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/17 11:44 上午
 */
public class MyTargetLoader<T> {

    public T loadClass(Class<T> clz) throws IllegalAccessException, InstantiationException {
        if (clz.isAnnotationPresent(MyTarget.class)) {
            System.out.printf("class: %s 被MyTarget 注解标记了 \n", clz.toString());
        }
        return clz.newInstance();
    }

}
