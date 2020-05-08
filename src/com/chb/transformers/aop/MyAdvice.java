package com.chb.transformers.aop;

import org.aopalliance.aop.Advice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;
import org.springframework.dao.PessimisticLockingFailureException;
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
