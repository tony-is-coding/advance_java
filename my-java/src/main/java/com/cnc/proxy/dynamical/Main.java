package com.cnc.proxy.dynamical;

public class Main {
    public static void main(String[] args) {
        MapperProxy proxy = new MapperProxy();

        UserMapper userMapperProxy = proxy.newInstance(UserMapper.class);

        User user = userMapperProxy.getUserById(1000);
        String s = userMapperProxy.toString();
        System.out.println(s);

    }
}
