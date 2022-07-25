package com.cnc.myboot.transations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * #TODO: desc
 * </p>
 *
 * @author zhiyong.tan
 * @since 2022-07-25
 */
@SpringBootApplication(scanBasePackages = "com.cnc.myboot.transactions.*")
public class TransactionApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

    @Value("${app.name}")
    private String appName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(appName);
    }
}
