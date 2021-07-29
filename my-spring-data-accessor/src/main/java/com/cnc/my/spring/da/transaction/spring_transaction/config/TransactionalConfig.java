package com.cnc.my.spring.da.transaction.spring_transaction.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.cnc.my.spring.da.transaction")
public class TransactionalConfig {

    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://114.67.81.63:3307/java_std?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("admin123");
        ds.setMaxActive(20);
        ds.setInitialSize(1);
        ds.setMaxWait(60 * 1000);
        ds.setMinIdle(1);
        ds.setPoolPreparedStatements(true);
        ds.setMaxPoolPreparedStatementPerConnectionSize(20);

        return ds;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    // Hibernate 5.x 系列配置
//    @Bean
//    public LocalSessionFactoryBean sessionFactoryBean() {
//        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
//        bean.setDataSource(dataSource());
//        bean.setMappingResources("hibernate.mapping.resource.xml");
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.MySQL57Dialect");
//        bean.setHibernateProperties(properties);
//        return bean;
//    }
//    @Bean
//    public EntityManagerFactory entityManagerFactory(){
//        return new LocalEntityManagerFactoryBean();
//    }

}
