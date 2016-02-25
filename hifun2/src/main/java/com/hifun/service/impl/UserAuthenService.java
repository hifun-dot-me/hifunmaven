package com.hifun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hifun.base.session.SessionUser;
import com.hifun.dao.IUserAuthenDao;
import com.hifun.service.IUserAuthenService;

@Service
public class UserAuthenService implements IUserAuthenService {

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
