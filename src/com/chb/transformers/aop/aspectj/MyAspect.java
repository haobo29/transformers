package com.chb.transformers.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class MyAspect {

	@Pointcut("execution(public * com.chb.transformers.service.*.*(..))")
	public void beforeSave() {}
	
	@Before("beforeSave()")
	public void log1() {
		
		System.out.println("beforeSave22¡¤¡¤");
	}
	
}

