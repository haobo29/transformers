package com.chb.transformers.service;

import org.springframework.stereotype.Component;

@Component("service")
public class MyService implements Service{
    public void save(){
        System.out.println("MyService.save");
    }
    public String query(String queryParam){
        System.out.println(queryParam);
        return queryParam;
    }
    
   
}
