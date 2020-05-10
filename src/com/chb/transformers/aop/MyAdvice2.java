package com.chb.transformers.aop;

import com.chb.transformers.pojo.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
@Order(10)
public class MyAdvice2 implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) {
        System.out.println("before");
    }

    @Before("MyAdvice1.asSave() and args(user)")
    public void before2(User user){
        System.out.println("name2: "+ user.getName()+", age2: "+ user.getAge());
    }
}
