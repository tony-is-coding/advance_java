package com.cnc.my.spring.spring_tx.service;

import java.math.BigDecimal;

public interface AccountService {

    void transfer(Integer fromAccount, Integer toAccount, BigDecimal amount);
}
