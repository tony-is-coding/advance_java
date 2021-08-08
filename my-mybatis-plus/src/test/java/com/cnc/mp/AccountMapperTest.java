package com.cnc.mp;

import com.cnc.mp.entity.Account;
import com.cnc.mp.mapper.AccountMapper;
import com.cnc.mp.service.AccountDaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {

    @Resource
    AccountMapper mapper;
    @Autowired
    AccountDaoService accountDaoService;

    @Test
    public void testQueryAll() {
        System.out.println("select all entity method start ....");
        List<Account> accountList = mapper.selectList(null);
        accountList.forEach(System.out::println);
    }

    @Test
    public void testTransferSuccess() {
        System.out.println("start test transfer method... ");
        List<Account> accountList = accountDaoService.listByIds(Arrays.asList(2, 3));
        accountDaoService.transfer(accountList.get(0), accountList.get(1), BigDecimal.valueOf(200));
        System.out.println("transfer successful...");
    }

}
