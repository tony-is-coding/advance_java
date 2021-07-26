package com.cnc.my.spring.da.transaction.spring_transaction.service.impl;

import com.cnc.my.spring.da.transaction.spring_transaction.Foo;
import com.cnc.my.spring.da.transaction.spring_transaction.service.FooService;
import org.springframework.transaction.annotation.Transactional;


public class DefaultFooService  implements FooService {
    @Override
    public Foo getFoo(String fooName) {
        return null;
    }

    @Override
    public Foo getFoo(String fooName, String barName) {
        return null;
    }

    @Override
    public void insertFoo(Foo foo) {
    }

    @Override
    @Transactional
    public void updateFoo(Foo foo) {

    }
}
