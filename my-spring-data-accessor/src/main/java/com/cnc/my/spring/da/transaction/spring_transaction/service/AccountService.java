package com.cnc.my.spring.da.transaction.spring_transaction.service;

import java.math.BigDecimal;

public interface AccountService {

    void transfer(Integer fromAccount, Integer toAccount, BigDecimal amount);
}
