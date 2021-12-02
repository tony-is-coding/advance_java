package com.cnc.my.spring.spring_tx.dao;

import com.cnc.my.spring.spring_tx.entity.UserBase;

import java.util.List;

public interface UserDao {
    UserBase queryById(Integer id);

    List<UserBase> queryAll();
}
