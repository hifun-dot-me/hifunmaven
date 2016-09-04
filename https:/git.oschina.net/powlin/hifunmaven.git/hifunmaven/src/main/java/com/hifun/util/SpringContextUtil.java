package com.hifun.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext acx) {
        context = acx;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }
}
