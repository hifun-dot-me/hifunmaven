package com.hifun.dao;

import com.hifun.base.session.SessionUser;

public interface IUserAuthenDao {

    /**
     * 查询用户名和密码是否匹配
     * @param username
     * @param password
     * @return 
     * @create: 2016年1月27日 下午11:08:02 yuexia
     * @history:
     */
    SessionUser queryUser(String username, String password);

    /**
     * 根据用户名查询用户
     * @param username
     * @return 
     * @create: 2016年1月29日 下午9:22:50 yuexia
     * @history:
     */
    SessionUser queryUserByUsername(String username);

    /**
     * 保存用户名和密码
     * @param username
     * @param nickname
     * @param password 
     * @create: 2016年1月29日 下午9:32:50 yuexia
     * @history:
     */
    void insertUserInfo(String username, String nickname, String password);

    /**
     * 增加用户经验
     * @param username
     * @create: 2016年2月1日09:20:22 yuexia
     * @param exp
     */
    void updateUserExp(String username, int exp);

    /**
     * 根据用户名更新签到信息
     * @param username
     * @param nowdate 
     * @create: 2016年3月15日 下午10:46:17 yuexia
     * @history:
     */
    void updateUserSign(String username, String nowdate);

    /**
     * 根据昵称查询用户数量
     * @param nickname
     * @return 
     * @create: 2016年4月2日 下午5:11:46 yuexia
     * @history:
     */
    Integer queryUserCountByNickname(String nickname);

}
