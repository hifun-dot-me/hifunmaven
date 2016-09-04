package com.hifun.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hifun.base.session.ISessionProvider;
import com.hifun.base.session.SessionUser;
import com.hifun.base.session.UserDetailHolder;

public class BaseService {

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
	
}
