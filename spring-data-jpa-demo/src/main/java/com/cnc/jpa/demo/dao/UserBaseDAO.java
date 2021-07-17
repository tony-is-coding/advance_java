package com.cnc.jpa.demo.dao;


import com.cnc.jpa.demo.entity.UserBase;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface UserBaseDAO extends Repository<UserBase, Integer> {
    List<UserBase> findAll();
}

