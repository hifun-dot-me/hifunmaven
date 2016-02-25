package com.hifun.base.session;

/**
 * 真正的会话提供者
 * @author: yuexia 
 * @since: 2016年1月29日 下午11:34:42 
 * @history:
 */
public interface ISessionProvider {
    String SESSION_KEY_USER = "user";

    /**
     * 存放登录用户信息
     * 
     * @param userDetail
     * @create: 2016年1月28日12:39:05
     * @history:
     */
    public void setUserDetail(AUserDetail userDetail);

    /**
     * 移除用户信息
     * 
     * @param userDetail
     * @create: 2016年1月28日12:39:05
     * @history:
     */
    public void removeUserDetail();

    /**
     * 获取用户对象
     * @return 
     * @create: 2016年1月28日12:39:05
     * @history:
     */
    public AUserDetail getUserDetail();

    /**
     * 存放值
     * 
     * @param name
     * @param value
     * @create: 2016年1月28日12:39:05
     * @history:
     */
    public void setAttribute(String name, Object value);

    /**
     * 获取key为name的值
     * 
     * @param request
     * @param name
     * @create: 2016年1月28日12:39:05
     * @history:
     */
    public Object getAttribute(String name);

    /**
     * 移除某个值
     * 
     * @param name
     * @create: 2016年1月28日12:39:05
     * @history:
     */
    public void removeAttribute(String name);

}
