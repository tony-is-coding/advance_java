package com.cnc.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName(value = "account")
public class Account {
    @TableId(type = IdType.AUTO)
    private Integer accountId;

    private Integer userId;

    private BigDecimal amount;

    private LocalDateTime addDt;

    private LocalDateTime updateDt;
}
