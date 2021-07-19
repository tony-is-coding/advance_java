package com.cnc.jpa.demo.dao;

import com.cnc.jpa.demo.entity.UserBase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class UserBaseDaoTest {


    @Test
    public void testFindAll() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        UserBaseDAO userBaseDAO = (UserBaseDAO) context.getBean("userBaseDAO");
        JpaTransactionManager transactionManager = (JpaTransactionManager) context.getBean("transactionManager");
        try {
            EntityManager manager = transactionManager.getEntityManagerFactory().createEntityManager();
            EntityTransaction transaction = manager.getTransaction();
            UserBase userBase = new UserBase();
//            userBase.setId(1);
            userBase.setAddr("深圳市宝安区劳动二队");
            userBase.setAge(25);
            userBase.setEmail("2318930092@qq.com");
            userBase.setMobile("13421843857");
            userBase.setName("tony tan");
            transaction.begin();
            manager.persist(userBase);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}