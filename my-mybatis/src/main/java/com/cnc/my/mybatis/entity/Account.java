package com.cnc.my.mybatis.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {
    Integer account_id;
    Integer user_id;
    BigDecimal amount;
    LocalDateTime add_dt;
    LocalDateTime update_dt;
}
