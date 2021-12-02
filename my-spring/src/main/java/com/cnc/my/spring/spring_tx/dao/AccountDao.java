package com.cnc.my.spring.spring_tx.dao;

import java.math.BigDecimal;

public interface AccountDao {
    void increment(Integer account, BigDecimal amount);

    void decrement(Integer account, BigDecimal amount);
}
