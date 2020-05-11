package com.chb.transformers.aop;

import org.aopalliance.aop.Advice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice implements Ordered {
    @DeclareParents(value = "com.chb.transformers.service.*+",defaultImpl=DefaultUsageTracked.class)
    public static UsageTracked ut;

    public void after(){
        System.out.println("MyAdvice.after");
    }
    @Around("execution(* com.chb.transformers.service.MyService.query(String)) and args(queryParam)")
    public void around(ProceedingJoinPoint pjp, String queryParam) throws Throwable {
        System.out.println(queryParam);
        pjp.proceed(new Object[]{queryParam+"11111111111"});
    }

    @Around("execution(* com.chb.transformers.service.*.*(..)) and\n" +
            "                        @annotation(com.chb.transformers.aop.Idempotent)")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        int numAttempts = 0;
        PessimisticLockingFailureException lockFailureException;
        do {
            numAttempts++;
            try {
                System.out.println(numAttempts);
                return pjp.proceed();
            }
            catch(PessimisticLockingFailureException ex) {
                lockFailureException = ex;
            }
        } while(numAttempts <= 3);
        throw lockFailureException;
    }
    @Override
    public int getOrder() {
        return 10;
    }
}
