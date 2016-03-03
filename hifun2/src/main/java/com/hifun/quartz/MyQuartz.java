package com.hifun.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyQuartz implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		this.work();
	}
	
	public synchronized void work(){
		System.out.println("quartz syso...");
	}

}
