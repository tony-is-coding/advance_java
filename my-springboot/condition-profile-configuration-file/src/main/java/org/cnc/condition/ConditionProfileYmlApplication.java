package org.cnc.condition;

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
 * @since 2022-08-06
 */
@SpringBootApplication
public class ConditionProfileYmlApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConditionProfileYmlApplication.class, args);
    }

    @Value("${server.profile}")
    private String profile;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("server.profile : " + profile);
    }
}
