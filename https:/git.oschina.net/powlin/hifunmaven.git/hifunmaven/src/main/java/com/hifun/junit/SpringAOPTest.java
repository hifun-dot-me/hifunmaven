package com.hifun.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hifun.service.IHeadService;
import com.hifun.service.impl.HeadServiceImpl;

public class SpringAOPTest {  
	
    @Test  
    public void inteceptorTest(){  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");  
        IHeadService headService = (HeadServiceImpl)ctx.getBean(HeadServiceImpl.class);  
        headService.queryBannerValidateList();
    }  
      
  
}
