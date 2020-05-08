package com.chb.transformers.aop;

import org.aopalliance.aop.Advice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component("myAdvice")
public class MyAdvice implements Ordered {
    public void after(){
        System.out.println("MyAdvice.after");
    }
    public void around(ProceedingJoinPoint pjp, String queryParam) throws Throwable {
        System.out.println(queryParam);
        System.out.println(pjp.proceed());
    }
    public void recordUsage(UsageTracked ut){
        ut.incrementUseCount();
        System.out.println(ut.getCount());
    }
    @Override
    public int getOrder() {
        return 10;
    }
}
