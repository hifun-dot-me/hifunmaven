package com.hifun.dao;

import java.util.List;
import java.util.Map;

import com.hifun.base.session.SessionUser;
import com.hifun.bean.Banner;
import com.hifun.bean.HiThings;
import com.hifun.bean.Menu;
import com.hifun.bean.Shop;

public interface IHeadDao {

    /**
     * 获取生效的banner-按时间倒序最多6个
     * @return 
     * @create: 2016年1月21日 下午9:07:03 yuexia
     * @history:
     */
    List<Banner> queryBannerValidateList();

    /**
     * 获取生效的菜单
     * @return
     * @create: 2016年1月22日上午09:19:23 yuexia
     * @history:
     */
    List<Menu> queryMenuValidateList();

    /**
     * 判断今日是否签到
     * @param username
     * @param nowdate
     * @return 
     * @create: 2016年1月31日 下午9:33:34 yuexia
     * @history:
     */
    Integer queryTodayIsSign(String username, String nowdate);

    /**
     * 保存签到记录
     * @param username
     * @param nowdate 
     * @param signOrder
     * @create: 2016年1月31日 下午11:04:33 yuexia
     * @history:
     */
    void insertSign(String username, String nowdate, int signOrder);

    /**
     * 查询今日签到数
     * @param nowdate
     * @return 
     * @create: 2016年1月31日 下午11:26:52 yuexia
     * @history:
     */
    Integer querySignCount(String nowdate);

    /**
     * 查询今日是否已签到
     * @param nowdate
     * @param username
     * @return 
     * @create: 2016年1月31日 下午11:42:05 yuexia
     * @history:
     */
    Integer querySignCount(String nowdate, String username);

    /**
     * 查询经验值前十的用户列表
     * @return 
     * @create: 2016年2月2日 下午9:54:13 yuexia
     * @history:
     */
    List<SessionUser> queryTopTenUsers();

    /**
     * 根据审核状态查询嗨百事列表（前端查询审核通过的列表）
     * @param status
     * @return 
     * @create: 2016年2月14日 下午9:56:12 yuexia
     * @history:
     */
    List<HiThings> queryHiThingsByStatus(int status);

    /**
     * 根据审核状态查询嗨百事列表（前端查询审核通过的列表）
     * @param username
     * @param status
     * @return 
     * @create: 2016年2月14日 下午9:56:12 yuexia
     * @history:
     */
    List<HiThings> queryHiThingsByStatus(String username, int status);

    /**
     * 保存嗨百事
     * @param content
     * @param username
     * @param nowdate 
     * @create: 2016年2月15日 下午11:25:38 yuexia
     * @history:
     */
    void insertHiThings(String content, String username, String nowdate);

    /**
     * 保存嗨ground
     * @param content
     * @param username
     * @param nowdate 
     * @create: 2016年3月1日 下午10:05:08 yuexia
     * @history:
     */
    void insertHiPlayground(String content, String username, String nowdate);

    /**
     * 根据关联名称查询关联id
     * @param relateTypeName
     * @return 
     * @create: 2016年2月18日 下午9:09:48 yuexia
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
     * @create: 2016年2月18日 下午9:19:56 yuexia
     * @history:
     */
    void insertEvaluate(String username, String nowdate, int evaluateId,
            int evaluateTypeId, int relateTypeId);

    /**
     * 查询是否赞过或踩过
     * @param evaluateId
     * @param username
     * @return 
     * @create: 2016年2月18日 下午9:32:22 yuexia
     * @history:
     */
    int queryEvaluateCount(int evaluateId, String username);

    /**
     * 根据评价类型判断增加哪个值
     * @param evaluateId
     * @param evaluateTypeId 
     * @create: 2016年2月18日 下午10:01:29 yuexia
     * @history:
     */
    void updateHiThingsNum(int evaluateId, int evaluateTypeId);

    /**
     * 查询今天所有的赞数
     * @param nowdate
     * @param username
     * @param relateTypeId
     * @return 
     * @create: 2016年2月18日 下午10:31:04 yuexia
     * @history:
     */
    int queryTotalZan(String nowdate, String username, int relateTypeId);

    /**
     * 查询所有嗨ground
     * @param status
     * @param shopName
     * @return 
     * @create: 2016年3月1日 下午10:25:42 yuexia
     * @history:
     */
    List<Shop> queryAllShopByStatus(int status, String shopName);

    /**
     * 查询签到map<username, signNum>
     * @param username
     * @return 
     * @create: 2016年3月6日 下午5:45:14 yuexia
     * @history:
     */
    Map<String, Integer> querySignMap(String username);

    /**
     * 根据用户名更新签到数
     * @param username 
     * @param daynum
     * @create: 2016年3月6日 下午8:59:23 yuexia
     * @history:
     */
    void updateUserSignByUsername(String username, Integer daynum);

    /**
     * 保存商家注册信息
     * @param username
     * @param shopName
     * @param shopType
     * @param shopLevel
     * @param shopDesc
     * @param shopAddr
     * @param status
     * @param nowdate 
     * @create: 2016年3月19日 下午9:16:38 yuexia
     * @history:
     */
    void insertShop(String username, String shopName, int shopType,
            int shopLevel, String shopDesc, String shopAddr, int status,
            String nowdate);

    /**
     * 根据用户名查询商家数量
     * @param username
     * @return 
     * @create: 2016年3月19日 下午11:07:43 yuexia
     * @history:
     */
    Integer queryShopCountByUsername(String username);

    /**
     * 保存好友申请记录
     * @param username
     * @param applyusername
     * @param nowdate 
     * @create: 2016年3月29日 下午11:16:39 yuexia
     * @history:
     */
    void insertApplyFriend(String username, String applyusername,
            String nowdate);

    /**
     * 查询是否已申请过
     * @param username
     * @param applyTo
     * @return 
     * @create: 2016年3月31日 下午9:48:10 yuexia
     * @history:
     */
    int queryApplyFriendCount(String username, String applyTo);
}
