package com.cnc.my.spring.spring_tx.dao;

import com.cnc.my.spring.spring_tx.entity.Product;

public interface ProductDao {
    void queryById(Integer id);

    void insertOne(Product product);
}
