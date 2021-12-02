package com.cnc.annotation.extension;


import java.lang.annotation.*;


/**
 * SPI拓展标记, 被此注解标记的接口将被允许作为可拓展接口使用
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SPI {
}
