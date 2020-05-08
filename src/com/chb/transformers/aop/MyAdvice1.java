package com.chb.transformers.aop;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component("myAdvice1")
public class MyAdvice1 implements Ordered {

    @Override
    public int getOrder() {
        return 1;
    }

    public void after(){
        System.out.println("MyAdvice1.after");
    }
}
