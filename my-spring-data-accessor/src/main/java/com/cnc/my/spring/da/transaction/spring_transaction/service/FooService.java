package com.cnc.my.spring.da.transaction.spring_transaction.service;

import com.cnc.my.spring.da.transaction.spring_transaction.Foo;

public interface FooService {

    Foo getFoo(String fooName);

    Foo getFoo(String fooName, String barName);

    void insertFoo(Foo foo);

    void updateFoo(Foo foo);
}
