package com.chb.transformers.service;

import com.chb.transformers.aop.Idempotent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyService {
    public void save(){
        System.out.println("MyService.save");
    }
    public String query(String queryParam){
        System.out.println("MyService.query");
        return queryParam;
    }
    @Idempotent
    public void update(){
        System.out.println("MyService.update");
    }
}
