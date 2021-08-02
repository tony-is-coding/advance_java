package com.cnc.myboot.cache.service;

import com.cnc.myboot.ExampleApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = ExampleApplication.class)
public class RuleCacheServiceTest {
    @Autowired
    RuleCacheService ruleCacheService;

    @Test
    public void testCacheGetInt() {

        int r1 = ruleCacheService.getInt();
        System.out.println("第一次访问, 值为:" + r1);
        int r2 = ruleCacheService.getInt();
        System.out.println("第一次访问, 值为:" + r2);
        int r3 = ruleCacheService.getInt();
        System.out.println("第一次访问, 值为:" + r3);
    }

    @Test
    public void testCacheMappingGetInt() {
        Integer input = 100;

        int r1 = ruleCacheService.getInt(input);
        System.out.println("第一次访问, 值为:" + r1);
        int r2 = ruleCacheService.getInt(input);
        System.out.println("第一次访问, 值为:" + r2);
        int r3 = ruleCacheService.getInt(input);
        System.out.println("第一次访问, 值为:" + r3);


        Integer input2 = 200;

        int r21 = ruleCacheService.getInt(input2);
        System.out.println("第一次访问, 值为:" + r1);
        int r22 = ruleCacheService.getInt(input2);
        System.out.println("第一次访问, 值为:" + r2);

    }
}