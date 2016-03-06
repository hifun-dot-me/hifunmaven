package com.hifun.quartz;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.hifun.base.SpringContext;
import com.hifun.service.IHeadService;
import com.hifun.service.impl.HeadServiceImpl;

/**
 * 签到计算定时器-每日0点5分计算连续签到数
 * @author: yuexia 
 * @since: 2016年3月6日 下午5:34:10 
 * @history:
 */
public class SignCalcQuartz implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        this.work();
    }

    public synchronized void work() {
        IHeadService headService = SpringContext.getBean(HeadServiceImpl.class);
        Map<String, Integer> signMap = headService.querySignMap(null);
        for (String key : signMap.keySet()) {
            System.out.println(key + "->" + signMap.get(key));
        }
    }

}
