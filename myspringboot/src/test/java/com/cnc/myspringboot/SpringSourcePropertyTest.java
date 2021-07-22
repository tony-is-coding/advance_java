package com.cnc.myspringboot;


import com.cnc.myspringboot.configscan.SpringAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class SpringSourcePropertyTest {

    /**
     * 	@PropertySource 注释是可重复的，
     * 	根据Java的8约定。但是，所有此类@PropertySource注释都需要在同一级别声明，可以直接在配置类上声明，
     * 	也可以作为同一自定义注释中的元注释。不推荐混合直接注释和元注释，因为直接注释有效地覆盖了元注释。
     */
    @Test
    public void testGetProperty() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        Environment env = context.getEnvironment();
        System.setProperty("isOpen", "false");
        boolean hasBean = env.getProperty("isOpen", Boolean.class);
        System.out.println(hasBean);

        int port = env.getProperty("server.port", Integer.class);
        System.out.println(port);
    }
}
