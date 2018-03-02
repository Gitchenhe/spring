package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 声明切面
 * Created by chenhe on 2018/2/23.
 */
@Aspect
@Configuration
public class DemoAspect {

    Logger logger = LoggerFactory.getLogger(DemoAspect.class);
    /**
     * 声明切入点, 可以声明多个切点
     */
    @Pointcut("execution( * com.example.demo.*.*.*(..))")
    public void demoPointCut(){
        logger.info("切面执行了...");
    }

    @Before("demoPointCut() && args(text)")
    public void before(String text){
        logger.info("切面before执行了,args = {}",text);
    }

    @After("demoPointCut()")
    public void after(){
        logger.info("切面after执行了");
    }

    @AfterReturning(value = "demoPointCut()",returning = "returnVal")
    public void afterReturn(Object returnVal){
        logger.info("切面afterReturn执行了,返回值:{}",returnVal);
    }

    @AfterThrowing(pointcut = "demoPointCut()", throwing = "ex")
    public void afterThrowing(Exception ex){
        logger.info("切面afterThrowing执行了");
    }

    @Around("demoPointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        logger.info("切面 around before 执行了");
        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("切面 around after 执行了");
        return object;
    }
}
