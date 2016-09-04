package com.hifun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hifun.base.ControllerContext;
import com.hifun.base.session.ISessionProvider;
import com.hifun.base.session.SessionUser;
import com.hifun.base.session.UserDetailHolder;

/**
 * 
 * @author: yuexia 
 * @since: 2016年1月27日 下午11:37:02 
 * @history:
 */
@Controller
public class BaseController {

    @Autowired
    protected ISessionProvider sessionProvider;

    /**
     * 获取session user
     * 
     * @return
     */
    protected SessionUser getSessionUser() {
        SessionUser user = (SessionUser) UserDetailHolder.getUserDetail();
        return user;
    }

    /**
     * 获取IP地址
     * 
     * @return
     */
    protected String getRemoteHost() {
        String ip = ControllerContext.getRequest().getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = ControllerContext.getRequest().getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = ControllerContext.getRequest().getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = ControllerContext.getRequest().getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

}
