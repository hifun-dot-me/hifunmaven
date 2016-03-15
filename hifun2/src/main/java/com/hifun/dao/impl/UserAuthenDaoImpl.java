package com.hifun.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hifun.base.session.SessionUser;
import com.hifun.dao.BaseDao;
import com.hifun.dao.IUserAuthenDao;

@Component
public class UserAuthenDaoImpl extends BaseDao implements IUserAuthenDao {

    @Override
    public SessionUser queryUser(String username, String password) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("password", password);
        Object obj = getSqlMapClientTemplate().queryForObject("query-user",
            param);
        return obj == null ? null : (SessionUser) obj;
    }

    @Override
    public SessionUser queryUserByUsername(String username) {
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-user-byusername", username);
        return obj == null ? null : (SessionUser) obj;
    }

    @Override
    public void insertUserInfo(String username, String password) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("password", password);
        getSqlMapClientTemplate().insert("insert-userinfo", param);
    }

    @Override
    public void updateUserExp(String username, int exp) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("exp", exp);
        getSqlMapClientTemplate().insert("update-userexp", param);
    }

    @Override
    public void updateUserSign(String username, String nowdate) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("nowdate", nowdate);
        getSqlMapClientTemplate().update("updat-usersign", param);
    }

}
