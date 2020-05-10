package com.chb.transformers.service;

import org.springframework.stereotype.Service;

@Service
public class AspectService {

    public String save(){
        System.out.println("AspectService.save");
        return "11111111111111";
    }
}
