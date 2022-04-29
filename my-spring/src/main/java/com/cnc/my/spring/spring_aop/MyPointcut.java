package com.cnc.my.spring.spring_aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyPointcut {
    /**
     * 切入点确定感兴趣的连接点，从而使我们能够控制通知何时运行。Spring AOP 仅支持 Spring bean 的方法执行连接点，因此您可以将切入点视为匹配 Spring bean 上方法的执行。
     * 一个切入点声明有两个部分：一个包含名称和任何参数的签名以及一个切入点表达式，它确定我们对哪些方法执行感兴趣。在 AOP 的@AspectJ 注释样式中，
     * 一个切入点签名由常规方法定义提供，切入点表达式通过@Pointcut注解表示（作为切入点签名的方法必须有void返回类型）。
     */

    /**
     * 可以认为SpringAOP 的切入点其实就是为了匹配 被切面装饰的bean上的方法(匹配上的一些), pointcut 只起到匹配的功能
     *
     */

    /**
     * /////// Spring 切入点支持以下切入匹配模式 //////
     * <p>
     * execution: 用于匹配方法执行连接点。这是使用 Spring AOP 时要使用的主要切入点指示符。
     * <p>
     * within：将匹配限制为某些类型内的连接点（使用 Spring AOP 时在匹配类型中声明的方法的执行）。
     * <p>
     * this: 限制匹配连接点（使用 Spring AOP 时的方法执行），其中 bean 引用（Spring AOP 代理）是给定类型的实例。
     * <p>
     * target: 限制匹配连接点（使用 Spring AOP 时的方法执行），其中目标对象（被代理的应用程序对象）是给定类型的实例。
     * <p>
     * args: 限制匹配连接点（使用 Spring AOP 时的方法执行），其中参数是给定类型的实例。
     *
     * @target: 将匹配限制为连接点（使用 Spring AOP 时的方法执行），其中执行对象的类具有给定类型的注释。
     * @args：限制匹配连接点（使用 Spring AOP 时的方法执行），其中传递的实际参数的运行时类型具有给定类型的注释。
     * @within: 限制匹配到具有给定注解的类型中的连接点（使用 Spring AOP 时，在具有给定注解的类型中声明的方法的执行）。
     * @annotation：将匹配限制为连接点的主题（在 Spring AOP 中运行的方法）具有给定注释的连接点。
     */

    @Pointcut("execution(public * *(..))")
    public void anyPublic() {
        // 此 pointcut 匹配所有的公共方法

    }


    @Pointcut("within(com.cnc.my.spring.spring_aop..*)")
    public void anyInPackage() {
        // 此 pointcut 匹配所有的在 `com.cnc.myspringboot.spring_aop`包下的类的方法
    }

    // 结合使用模式

    @Pointcut("anyPublic() && anyInPackage()")
    public void publicInPackage() {
        // 此 pointcut 匹配所有的在 `com.cnc.myspringboot.spring_aop`包下的类的所有 `public` 方法
    }

}
