package com.cnc.my.mybatis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * @author zhiyong.tan
 * @date
 */
@Data
public class Account {
    Integer accountId;

    Integer userId;

    BigDecimal amount;

    LocalDateTime addDt;

    LocalDateTime updateDt;
}


