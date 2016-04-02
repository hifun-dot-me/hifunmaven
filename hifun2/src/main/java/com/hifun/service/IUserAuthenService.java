package com.hifun.service;

import com.hifun.base.session.SessionUser;

public interface IUserAuthenService {

    /**
     * 查询用户名和密码是否匹配
     * @param username
     * @param password
     * @return 
     * @create: 2016年1月27日 下午11:06:38 yuexia
     * @history:
     */
    SessionUser queryUser(String username, String password);

    /**
     * 根据用户名查询用户
     * @param username
     * @return 
     * @create: 2016年1月29日 下午9:22:20 yuexia
     * @history:
     */
    SessionUser queryUserByUsername(String username);

    /**
     * 根据昵称查询用户数量
     * @param nickname
     * @return 
     * @create: 2016年1月29日 下午9:22:20 yuexia
     * @history:
     */
    Integer queryUserCountByNickname(String nickname);

    /**
     * 保存用户名和密码
     * @param username
     * @param nickname
     * @param password 
     * @create: 2016年1月29日 下午9:32:00 yuexia
     * @history:
     */
    void insertUserInfo(String username, String nickname, String password);

}
