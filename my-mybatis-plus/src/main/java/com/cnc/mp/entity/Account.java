package com.cnc.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author zhiyong.tan
 */
@Data
@TableName(value = "t_account")
public class Account {
    @TableId(type = IdType.AUTO)
    private Integer accountId;

    private Integer userId;

    private BigDecimal amount;
}
