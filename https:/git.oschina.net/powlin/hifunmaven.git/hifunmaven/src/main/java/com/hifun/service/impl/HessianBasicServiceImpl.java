package com.hifun.service.impl;

import com.hifun.service.HessianBasicService;

public class HessianBasicServiceImpl implements HessianBasicService {

	private ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	private String greeting = "Hello, world";
	
	@Override
	public String hello1() {
		return threadLocal.get()==null?greeting:threadLocal.get();
	}

	@Override
	public void setProperty(String property) {
		threadLocal.set(property);
	}
	
}
