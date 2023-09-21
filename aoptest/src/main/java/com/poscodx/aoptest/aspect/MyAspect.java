package com.poscodx.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspect {

    @Before("execution(public com.poscodx.aoptest.vo.ProductVo com.poscodx.aoptest.service.ProductService.find(String))")
    public void adviceBefore() {
        System.out.println("---- Before Advice ----");
    }

    @After("execution(com.poscodx.aoptest.vo.ProductVo com.poscodx.aoptest.service.ProductService.find(String))")
    public void adviceAfter() {
        System.out.println("---- After Advice ----");
    }

    @AfterReturning("execution(* com.poscodx.aoptest.service.ProductService.find(String))")
    public void adviceAfterReturning() {
        System.out.println("---- AfterReturning Advice ----");
    }

    @AfterThrowing(value = "execution(* *..*.ProductService.find(..))", throwing = "ex")
    public void adviceAfterThrowing(Throwable ex) {
        System.out.println("---- AfterThrowing Advice:" + ex + " ----");
    }

    @Around("execution(* *..*.ProductService.*(..))")
    public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable {

        //before
        System.out.println("---- Around(before) Advice ----");
        
        //point cut method 실행
        Object result = pjp.proceed();
//        Object[] params = {"Camera"};
//        Object result = pjp.proceed(params);

        //after
        System.out.println("---- Around(after) Advice ----");
        return result;
    }

}
