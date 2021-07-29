package com.cnc.my.spring.da.transaction.spring_transaction.dao;

import com.cnc.my.spring.da.transaction.spring_transaction.entity.Product;

public interface ProductDao {
    void queryById(Integer id);

    void insertOne(Product product);
}
