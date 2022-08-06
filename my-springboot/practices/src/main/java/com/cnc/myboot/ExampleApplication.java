package com.cnc.myboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@ImportResource  可以用来加载具体的xml 配置或者其他配置
//@ComponentScan(basePackages = "com.cnc.myboot.myboot.*") 默认是扫描当前class 所属包下的所有类以及子包的类
@SpringBootApplication(scanBasePackages = "com.cnc.myboot.myboot.*")
@EnableCaching
public class ExampleApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
