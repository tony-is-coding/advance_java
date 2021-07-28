#### Spring 事务模型

Spring 事务的核心要素包含两层抽象:
- `DataSource` 数据源 
- `TransactionManager` 事务管理器

两者可以分别由不同的方案实现商实现; 整个spring 事务是通过TransactionManager对象去进行管理的;

spring 同时支持基于XML的事务声明和基于Annotation的事务声明

基于xml的配置核心是基于Spring-AOP配置思想,进行事务执行pointcut的包装处理; 实质上是每一层都
```xml
<!--   基于xml配置的事务模式核心思想就是给予SpringAOP或者AspectJ的面向切面编程感知  -->
    <!-- 配置事务增强 -->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <!--
                 propagation:事务传播行为:
                 isolation:隔离级别
                 read-only:是否为只读事务.
                 timeout    :是否超时.
                 rollback-for:类似-Exception.发生哪些异常回滚事务.
                 no-rollback-for:类似+Exception.发生哪些异常不回滚.
              -->
            <tx:method name="transfer" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>

    <!-- AOP的配置 -->
    <aop:config>
        <aop:pointcut
                expression="execution(* com.cnc.my.spring.da.transaction.spring_transaction.service.impl.AccountServiceImpl.*(..))"
                id="pointcut"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="pointcut"/>
    </aop:config>
```

```xml
    <!--  ************** 基于注解的事务配置 *************  -->
    <!-- 开启注解驱动事务模式 -->
    <tx:annotation-driven transaction-manager="transactionManager"/>
```