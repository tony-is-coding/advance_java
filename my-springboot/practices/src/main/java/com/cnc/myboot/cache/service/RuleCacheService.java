package com.cnc.myboot.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class RuleCacheService {


    @Cacheable("intCaching")
    public int getInt() {
        System.out.println("hello world");
        return 100;
    }

    @Cacheable("intMappingCache")
    public int getInt(Integer i) {
        System.out.println("数字为: " + i);
        return i + 100;
    }

}
