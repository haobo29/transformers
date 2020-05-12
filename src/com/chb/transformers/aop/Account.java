package com.chb.transformers.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chb.transformers.service.MyService;

@Configurable
@Component
@Scope("prototype")
public class Account {
	@Autowired
	private MyService service;
	
	public void save() {
		service.save();
	}
}
