package com.chb.transformers.aop.aspectj;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

import com.chb.transformers.aop.DefaultUsageTracked;
import com.chb.transformers.aop.UsageTracked;

public aspect MyAspect {
	@DeclareParents(value = "com.chb.transformers.service.*+",defaultImpl=DefaultUsageTracked.class)
    public static UsageTracked ut;

    
    @Before("execution(* com.chb.transformers.service.MyService.query(String)) && args(queryParam)")
    public void beforeQuery(String queryParam) {
        System.out.println("query param: "+queryParam);
    }

    @Before("execution(* com.chb.transformers.service.MyService.save())")
    public void beforeSave() {
    	System.out.println("beforeSave");
    }
    
	pointcut beforeUpdate() : execution(* com.chb.transformers.service.MyService.update());
	before() : beforeUpdate() {
		System.out.println("beforeUpdate");
	}
	
}
