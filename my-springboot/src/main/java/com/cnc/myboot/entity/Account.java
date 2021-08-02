package com.cnc.myboot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Integer Id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime addDt;

    private LocalDateTime updateDt;


    public Account() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getAddDt() {
        return addDt;
    }

    public void setAddDt(LocalDateTime addDt) {
        this.addDt = addDt;
    }

    public LocalDateTime getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(LocalDateTime updateDt) {
        this.updateDt = updateDt;
    }
}
