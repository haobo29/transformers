package com.chb.transformers.service;

import com.chb.transformers.aop.Idempotent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("myService")
public class MyService {
    public String save(){
        System.out.println("MyService.save");
        return "return";
    }
    public String query(String queryParam){
        System.out.println(queryParam);
        return queryParam;
    }
    @Idempotent
    public void update(){
        System.out.println("MyService.update");
    }
}
