package com.cnc.my.spring.spring_tx.service.impl;

import com.cnc.my.spring.spring_tx.dao.UserDao;
import com.cnc.my.spring.spring_tx.entity.UserBase;
import com.cnc.my.spring.spring_tx.service.UserBaseService;
import org.springframework.stereotype.Service;

@Service
public class UserBaseServiceImpl implements UserBaseService {

    final UserDao userDao;

    public UserBaseServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserBase getUserById(Integer id) {
        return userDao.queryById(id);
    }
}
