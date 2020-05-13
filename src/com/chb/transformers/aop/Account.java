package com.chb.transformers.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.chb.transformers.service.Service;

@Configurable
public class Account {
	@Autowired
	private Service service;
	
	public void setService(Service service) {
		this.service = service;
	}

	public void save() {
		service.save();
	}
}
