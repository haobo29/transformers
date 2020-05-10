package com.chb.transformers.aop;

import com.chb.transformers.pojo.User;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1000)
public class MyAdvice1 {
    @DeclareParents(value = "com.chb.transformers.service.*", defaultImpl = DefaultUsageTracked.class)
    public static UsageTracked mixin;

    @Pointcut("execution(* com.chb.transformers.service.AspectService.save(*))")
    public void asSave(){}

    @Before("asSave() and args(user)")
    public void before(User user){
        System.out.println("name: "+ user.getName()+", age: "+ user.getAge());
    }

    @AfterReturning(pointcut="com.chb.transformers.aop.MyAdvice1.asSave()",returning = "retVal")
    public void after(String retVal){
        System.out.println("MyAdvice1.after");
        System.out.println("return:"+retVal);
    }
    @Before("execution(* com.chb.transformers.service.MyService.save()) and this(ut)")
    public void recordUsage(UsageTracked ut){
        ut.incrementUseCount();
        System.out.println(ut.getCount());
    }
}
