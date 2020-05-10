package com.chb.transformers.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice1 {

    @Pointcut("execution(* com.chb.transformers.service.AspectService.save())")
    public void asSave(){}
    @Before("com.chb.transformers.aop.MyAdvice1.asSave()")
    public void before(){
        System.out.println("MyAdvice1.before");
    }
    @AfterReturning(pointcut="com.chb.transformers.aop.MyAdvice1.asSave()",returning = "retVal")
    public void after(String retVal){
        System.out.println("MyAdvice1.after");
        System.out.println("return:"+retVal);
    }
}
