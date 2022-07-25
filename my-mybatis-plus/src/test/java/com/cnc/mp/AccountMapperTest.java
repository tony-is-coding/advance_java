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
import java.io.IOException;
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
    public void testUpdateWithoutTransactional() {
        System.out.println("start test transfer method... ");
        List<Account> accountList = accountDaoService.listAccounts(Arrays.asList(1, 2));
        System.out.println(accountDaoService.updateWithoutTransactional(accountList.get(0), accountList.get(1), BigDecimal.valueOf(1000)));
    }

    @Test
    public void testRollbackSuccess() throws IOException {
        System.out.println("start test transfer method... ");
        List<Account> accountList = accountDaoService.listAccounts(Arrays.asList(1, 2));
        System.out.println(accountDaoService.transactionRollbackSuccess(accountList.get(0), accountList.get(1), BigDecimal.valueOf(1000)));
    }

    @Test
    public void testRollbackFailure() throws IOException {
        System.out.println("start test transfer method... ");
        List<Account> accountList = accountDaoService.listAccounts(Arrays.asList(1, 2));
        System.out.println(accountDaoService.transactionRollbackFailure(accountList.get(0), accountList.get(1), BigDecimal.valueOf(1000)));
    }

}
