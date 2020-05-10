package com.chb.transformers.service;

import com.chb.transformers.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class AspectService {

    public String save(User user){
        System.out.println("AspectService.save");
        return "11111111111111";
    }
}
