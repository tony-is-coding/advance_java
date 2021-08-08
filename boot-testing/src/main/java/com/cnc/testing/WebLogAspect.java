package com.cnc.testing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Aspect
@Component
public class WebLogAspect {
    private final Logger logger = Logger.getLogger(WebLogAspect.class.getName());

    @Pointcut("execution(public * com.cnc.testing..*.*(..))")
    public void controllerLog() {
    }

    @Before("controllerLog()")
    public void logBeforeController(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        logger.info("*************URL : " + request.getRequestURL().toString());
        logger.info("*************HTTP_METHOD : " + request.getMethod());
        logger.info("*************IP : " + request.getRemoteAddr());
    }
}