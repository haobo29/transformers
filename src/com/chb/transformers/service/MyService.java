package com.chb.transformers.service;


import com.chb.transformers.dao.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("service")
public class MyService {
    @Value("#{dao}")
    private MyDao dao;


    public void print(){

        System.out.println("MyService.print");
        dao.save();
    }
}
