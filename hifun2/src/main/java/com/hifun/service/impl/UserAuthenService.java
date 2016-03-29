package com.hifun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hifun.base.session.SessionUser;
import com.hifun.dao.IUserAuthenDao;
import com.hifun.service.BaseService;
import com.hifun.service.IUserAuthenService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserAuthenService extends BaseService implements IUserAuthenService {

    @Autowired
    private IUserAuthenDao userAuthenDao;

    @Override
    public SessionUser queryUser(String username, String password) {
        return userAuthenDao.queryUser(username, password);
    }

    @Override
    public SessionUser queryUserByUsername(String username) {
        return userAuthenDao.queryUserByUsername(username);
    }

    @Override
    public void insertUserInfo(String username, String password) {
        userAuthenDao.insertUserInfo(username, password);
    }

}
