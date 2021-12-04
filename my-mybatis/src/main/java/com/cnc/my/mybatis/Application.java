package com.cnc.my.mybatis;

import com.cnc.my.mybatis.entity.Account;
import com.cnc.my.mybatis.service.AccountService;
import com.cnc.my.mybatis.service.impl.AccountServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) {
        SqlSession session = null;
        try {
            String resource = "sql-map-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // 创建一个 SqlSessionFactory
            session = sqlSessionFactory.openSession(); // 创建一个 DefaultSqlSession, 重要的: executor 与 configuration
            AccountService accountService = new AccountServiceImpl();
            accountService.setSession(session);
            Account account = accountService.getById(1);
            System.out.println(account);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
