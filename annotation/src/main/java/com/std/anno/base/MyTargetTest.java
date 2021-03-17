package com.std.anno.base;

/**
 * @author tony
 * @desc TODO
 * @createDate 2021/3/17 11:32 上午
 */
public class MyTargetTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        MyTargetLoader<MyTargetUser> loader = new MyTargetLoader<>();
        System.out.println(loader.loadClass(MyTargetUser.class));

    }
}
