package com.cnc.myboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ExampleConfiguration {


    /**
     * SpringBoot 中的Spring MVC使用HttpMessageConverters实现拦截Http的请求和响应,进行 消息体的转换
     * 默认实现了: 对象的JSON 转换(Jackson), 字符串默认使用UTF-8编码
     */
//    @Bean
//    public HttpMessageConverters customHttpMessageConverters() {
//        HttpMessageConverter<?> customConvert = new GsonHttpMessageConverter();
//        return new HttpMessageConverters(customConvert);
//    }

    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

}
