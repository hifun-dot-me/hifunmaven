package com.hifun.quartz;

import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.hifun.util.HttpClientUtil;

public class DoSignQuartz implements Job {

    private final String[] usernameArr = { "powlin", "鸢尾" };

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        this.work();
    }

    public synchronized void work() {
        for (String username : usernameArr) {
            HttpClientUtil.doSign(username, "123456");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testWork() {
        this.work();
    }

}
