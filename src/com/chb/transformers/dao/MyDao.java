package com.chb.transformers.dao;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class MyDao {
    public void save(){
        System.out.println("MyDao.save");
    }
}
