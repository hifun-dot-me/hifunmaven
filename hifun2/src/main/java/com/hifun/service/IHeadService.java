package com.hifun.service;

import java.util.List;

import com.hifun.base.session.SessionUser;
import com.hifun.bean.Banner;
import com.hifun.bean.HiThings;
import com.hifun.bean.Menu;

public interface IHeadService {

    /**
     * 获取生效的banner-按时间倒序最多6个
     * @return 
     * @create: 2016年1月21日 下午9:06:35 yuexia
     * @history:
     */
    List<Banner> queryBannerValidateList();

    /**
     * 获取生效的菜单
     * @return
     * @create: 2016年1月22日上午09:18:37 yuexia
     * @history:
     */
    List<Menu> queryMenuValidateList();

    /**
     * 判断今日是否签到
     * @param username
     * @param nowdate
     * @return 
     * @create: 2016年1月31日 下午9:32:57 yuexia
     * @history:
     */
    Integer queryTodayIsSign(String username, String nowdate);

    /**
     * 保存签到记录
     * @param username
     * @param nowdate 
     * @param signOrder
     * @create: 2016年1月31日 下午11:03:16 yuexia
     * @history:
     */
    void insertSign(String username, String nowdate, int signOrder);

    /**
     * 查询今日签到数
     * @param nowTimeString
     * @return 
     * @create: 2016年1月31日 下午11:26:09 yuexia
     * @history:
     */
    Integer querySignCount(String nowdate);

    /**
     * 查询今日是否已签到
     * @param nowdate
     * @param username
     * @return 
     * @create: 2016年1月31日 下午11:41:19 yuexia
     * @history:
     */
    Integer querySignCount(String nowdate, String username);

    /**
     * 查询经验值前十的用户列表
     * @return 
     * @create: 2016年2月2日 下午9:53:25 yuexia
     * @history:
     */
    List<SessionUser> queryTopTenUsers();

    /**
     * 根据审核状态查询嗨百事列表（前端查询审核通过的列表）
     * @param username
     * @param status
     * @return 
     * @create: 2016年2月14日 下午9:55:04 yuexia
     * @history:
     */
    List<HiThings> queryHiThingsByStatus(String username, int status);

    /**
     * 根据审核状态查询嗨百事列表（前端查询审核通过的列表）
     * @param status
     * @return 
     * @create: 2016年2月14日 下午9:55:04 yuexia
     * @history:
     */
    List<HiThings> queryHiThingsByStatus(int status);

    /**
     * 保存嗨百事
     * @param content
     * @param username
     * @param nowdate 
     * @create: 2016年2月15日 下午11:24:27 yuexia
     * @history:
     */
    void insertHiThings(String content, String username, String nowdate);

    /**
     * 根据关联名称查询关联id
     * @param relateTypeName
     * @return 
     * @create: 2016年2月18日 下午9:09:01 yuexia
     * @history:
     */
    int queryEvaluateRelateIdByName(String relateTypeName);

    /**
     * 保存评价记录
     * @param username
     * @param nowdate
     * @param evaluateId
     * @param evaluateTypeId
     * @param relateTypeId 
     * @create: 2016年2月18日 下午9:18:53 yuexia
     * @history:
     */
    void insertEvaluate(String username, String nowdate, int evaluateId,
            int evaluateTypeId, int relateTypeId);

    /**
     * 查询是否赞过或踩过
     * @param evaluateId
     * @param username
     * @return 
     * @create: 2016年2月18日 下午9:31:40 yuexia
     * @history:
     */
    int queryEvaluateCount(int evaluateId, String username);

    /**
     * 查询今天所有的赞数
     * @param nowdate
     * @param username
     * @param relateTypeId
     * @return 
     * @create: 2016年2月18日 下午10:29:41 yuexia
     * @history:
     */
    int queryTotalZan(String nowdate, String username, int relateTypeId);

}
