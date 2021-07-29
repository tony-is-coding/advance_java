package com.cnc.my.spring.da.transaction.spring_transaction.service.impl;

import com.cnc.my.spring.da.transaction.spring_transaction.dao.UserDao;
import com.cnc.my.spring.da.transaction.spring_transaction.entity.UserBase;
import com.cnc.my.spring.da.transaction.spring_transaction.service.UserBaseService;
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
