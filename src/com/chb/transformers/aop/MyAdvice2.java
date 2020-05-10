package com.chb.transformers.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component("myAdvice2")
public class MyAdvice2 implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) {
        System.out.println("before");
    }
}
