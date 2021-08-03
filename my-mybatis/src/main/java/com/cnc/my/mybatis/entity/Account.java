package com.cnc.my.mybatis.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {
    Integer account_id;
    Integer user_id;
    BigDecimal amount;
    LocalDateTime add_dt;
    LocalDateTime update_dt;

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + account_id +
                ", userId=" + user_id +
                ", amount=" + amount +
                ", addDt=" + add_dt +
                ", updateDt=" + update_dt +
                '}';
    }
}
