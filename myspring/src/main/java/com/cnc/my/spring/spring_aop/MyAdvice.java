package com.cnc.my.spring.spring_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {
    /**
     * Advice 与切入点表达式相关联，并在与切入点匹配的方法执行之前、之后或周围运行。
     * 切入点表达式可以是对命名切入点的简单引用，也可以是就地声明的切入点表达式。
     */

    @Before("com.cnc.my.spring.spring_aop.MyPointcut.publicInPackage()")
    public void beforeExecution() {
        System.out.println("before method execution...");
    }

//    @AfterThrowing(pointcut = "com.cnc.myspringboot.spring_aop.MyPointcut.publicInPackage()", throwing = "e")
//    public void afterExceptionThrowing(Exception e) {
//        System.out.println("something exception happened!!!");
//    }

    @AfterReturning("com.cnc.my.spring.spring_aop.MyPointcut.publicInPackage()")
    public void afterExecutionReturning() {
        System.out.println("method has returned....");
    }
//
//    @After("com.cnc.myspringboot.spring_aop.MyPointcut.publicInPackage()")
//    public void afterExecution() {
//        System.out.println("method has already finished...");
//    }
//
    @Around("com.cnc.my.spring.spring_aop.MyPointcut.publicInPackage()")
    public Object aroundBark(ProceedingJoinPoint o) throws Throwable {
        System.out.println("around before bark!!!! ");
        Object ret = o.proceed();
        System.out.println("around after bark!!!! ");
        return ret;
    }


}
