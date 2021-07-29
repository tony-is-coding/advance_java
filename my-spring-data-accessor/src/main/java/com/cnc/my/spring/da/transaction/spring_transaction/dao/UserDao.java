package com.cnc.my.spring.da.transaction.spring_transaction.dao;

import com.cnc.my.spring.da.transaction.spring_transaction.entity.UserBase;

import java.util.List;

public interface UserDao {
    UserBase queryById(Integer id);

    List<UserBase> queryAll();
}
