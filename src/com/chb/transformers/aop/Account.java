package com.chb.transformers.aop;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import com.chb.transformers.service.Service;

@Configurable(autowire=Autowire.BY_TYPE)
public class Account {
	private Service service;
	private UsageTracked ut;
	
	public void setUt(UsageTracked ut) {
		this.ut = ut;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public void save() {
		service.save();
	}
}
