package com.hifun.service.impl;

import com.hifun.service.HessianBasicService;

public class HessianBasicServiceImpl implements HessianBasicService {

	private String greeting = "Hello, world";
	
	@Override
	public String hello1() {
		return greeting;
	}
	
}
