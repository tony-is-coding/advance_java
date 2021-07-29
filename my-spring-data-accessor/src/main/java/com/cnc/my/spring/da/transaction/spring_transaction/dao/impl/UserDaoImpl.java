package com.cnc.my.spring.da.transaction.spring_transaction.dao.impl;

import com.cnc.my.spring.da.transaction.spring_transaction.dao.UserDao;
import com.cnc.my.spring.da.transaction.spring_transaction.entity.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserBase queryById(Integer id) {
        return this.jdbcTemplate.queryForObject("select id,name,age,addr,email,mobile from t_user_base where id = ?", (rs, rowNum) -> {
            UserBase userBase = new UserBase();
            userBase.setId(rs.getInt("id"));
            userBase.setName(rs.getString("name"));
            userBase.setAge(rs.getInt("age"));
            userBase.setAddr(rs.getString("addr"));
            userBase.setEmail(rs.getString("email"));
            userBase.setMobile(rs.getString("mobile"));
            return userBase;
        }, id);
    }

    @Override
    public List<UserBase> queryAll() {
        return this.jdbcTemplate.queryForList("select id,name,age,addr,email,mobile from t_user_base where id ", UserBase.class);
    }
}
