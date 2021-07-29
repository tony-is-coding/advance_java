package com.cnc.my.spring.da.transaction.spring_transaction.dao.impl;

import com.cnc.my.spring.da.transaction.spring_transaction.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;

@Repository
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    /**
     * 支持命名占位参数的 JDBCTemplate
     * 结合sqlParameterSource 进行参数mapping设置
     */
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//    private SqlParameterSource sqlParameterSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void increment(Integer account, BigDecimal amount) {
        this.jdbcTemplate.update("update account set amount = amount + ? where account_id = ?", amount, account);
    }

    @Override
    public void decrement(Integer account, BigDecimal amount) {
        this.jdbcTemplate.update("update account set amount = amount - ? where account_id = ?", amount, account);
    }
}
