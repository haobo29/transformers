package com.chb.transformers.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	@Pointcut("execution(* com.chb.transformers.service.*.*(..))")
	public void beforeSave() {}
	
	@Before("beforeSave()")
	public void log() {
		System.out.println("beforeSave1¡¤¡¤");
	}
}
