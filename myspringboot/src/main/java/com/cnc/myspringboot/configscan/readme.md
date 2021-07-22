### Spring 配置注解扫描

spring 允许在 @Configuration 注解下的 bean 中配置 @ComponentScan 注解来达到指定包扫描 Spring Bean
(被 @Component、@Service、@Repository 等注解的 Bean class) 的目的;
通过 @ComponentScans 可以指定多个扫描路径

指定扫描路径可以一定程度上减少 Spring 的包扫描范围，提升项目启动速度