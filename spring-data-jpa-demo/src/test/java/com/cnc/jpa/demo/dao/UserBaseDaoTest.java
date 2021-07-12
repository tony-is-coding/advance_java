package com.cnc.jpa.demo.dao;

import com.cnc.jpa.demo.entity.UserBase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class UserBaseDaoTest {


    @Test
    public void testFindAll() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserBaseDAO userBaseDAO = (UserBaseDAO) context.getBean("userBaseDAO");
        try {
            List<UserBase> userBases = userBaseDAO.findAll();
            for(UserBase userBase:userBases){
                System.out.println("第" + userBase.getId() + "号学生, 名字叫: " + userBase.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}