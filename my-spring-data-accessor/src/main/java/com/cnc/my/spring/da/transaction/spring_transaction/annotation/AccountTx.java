package com.cnc.my.spring.da.transaction.spring_transaction.annotation;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(transactionManager = "transactionManager", label = "causal-consistency")
public @interface AccountTx {
    /**
     * 元注解,通用含义
     */
}
