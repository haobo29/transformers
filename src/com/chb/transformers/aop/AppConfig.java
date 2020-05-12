package com.chb.transformers.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@EnableAspectJAutoProxy
//@EnableSpringConfigured
@EnableLoadTimeWeaving
public class AppConfig {
}
