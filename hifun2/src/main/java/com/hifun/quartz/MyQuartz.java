package com.hifun.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.hifun.base.SpringContext;
import com.hifun.bean.TimeEnum;
import com.hifun.service.IHeadService;
import com.hifun.service.impl.HeadServiceImpl;
import com.hifun.util.DateUtil;


public class MyQuartz implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		this.work();
	}
	
	public synchronized void work(){
		IHeadService headService = SpringContext.getBean(HeadServiceImpl.class);
		System.out.println(headService.querySignCount(DateUtil.getNowTimeString(TimeEnum.DATE.getFormat())));
		System.out.println("quartz syso...");
	}

}
