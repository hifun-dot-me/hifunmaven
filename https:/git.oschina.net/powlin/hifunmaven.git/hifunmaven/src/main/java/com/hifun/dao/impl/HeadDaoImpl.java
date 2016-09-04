package com.hifun.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hifun.base.session.SessionUser;
import com.hifun.bean.ApplyFriend;
import com.hifun.bean.Banner;
import com.hifun.bean.HiThings;
import com.hifun.bean.Menu;
import com.hifun.bean.Shop;
import com.hifun.dao.BaseDao;
import com.hifun.dao.IHeadDao;

@Component
public class HeadDaoImpl extends BaseDao implements IHeadDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Banner> queryBannerValidateList() {
        return getSqlMapClientTemplate()
            .queryForList("query-banner-validatelist");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Menu> queryMenuValidateList() {
        return getSqlMapClientTemplate()
            .queryForList("query-menu-validatelist");
    }

    @Override
    public Integer queryTodayIsSign(String username, String nowdate) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("nowdate", nowdate);
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-todayissign", param);
        return obj == null ? 0 : (int) obj;
    }

    @Override
    public void insertSign(String username, String nowdate, int signOrder) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("nowdate", nowdate);
        param.put("signOrder", signOrder);
        getSqlMapClientTemplate().update("insert-sign", param);
    }

    @Override
    public Integer querySignCount(String nowdate) {
        Object obj = getSqlMapClientTemplate().queryForObject("query-signcount",
            nowdate);
        return obj == null ? 0 : (int) obj;
    }

    @Override
    public Integer querySignCount(String nowdate, String username) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("nowdate", nowdate);
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-signcount-bymap", param);
        return obj == null ? 0 : (int) obj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SessionUser> queryTopTenUsers() {
        Object obj = getSqlMapClientTemplate()
            .queryForList("query-toptenusers");
        return obj == null ? null : (List<SessionUser>) obj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HiThings> queryHiThingsByStatus(int status) {
        Object obj = getSqlMapClientTemplate()
            .queryForList("query-hithings-bystatus", status);
        return obj == null ? null : (List<HiThings>) obj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HiThings> queryHiThingsByStatus(String username, int status) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("status", status);
        Object obj = getSqlMapClientTemplate()
            .queryForList("query-hithings-byusernamestatus", param);
        return obj == null ? null : (List<HiThings>) obj;
    }

    @Override
    public void insertHiThings(String content, String username,
            String nowdate) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("nowdate", nowdate);
        param.put("content", content);
        getSqlMapClientTemplate().insert("insert-hithings", param);
    }

    @Override
    public void insertHiPlayground(String content, String username,
            String nowdate) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("nowdate", nowdate);
        param.put("content", content);
        getSqlMapClientTemplate().insert("insert-hiplayground", param);
    }

    @Override
    public int queryEvaluateRelateIdByName(String relateTypeName) {
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-evaluaterelateid-byname", relateTypeName);
        return obj == null ? 0 : (int) obj;
    }

    @Override
    public void insertEvaluate(String username, String nowdate, int evaluateId,
            int evaluateTypeId, int relateTypeId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("nowdate", nowdate);
        param.put("evaluateId", evaluateId);
        param.put("evaluateTypeId", evaluateTypeId);
        param.put("relateTypeId", relateTypeId);
        getSqlMapClientTemplate().insert("insert-evaluate", param);
    }

    @Override
    public int queryEvaluateCount(int evaluateId, String username) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("evaluateId", evaluateId);
        param.put("username", username);
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-evaluatecount", param);
        return obj == null ? 0 : (int) obj;
    }

    @Override
    public void updateHiThingsNum(int evaluateId, int evaluateTypeId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("evaluateId", evaluateId);
        param.put("evaluateTypeId", evaluateTypeId);
        getSqlMapClientTemplate().insert("update-hithingsnum", param);
    }

    @Override
    public int queryTotalZan(String nowdate, String username,
            int relateTypeId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("nowdate", nowdate);
        param.put("username", username);
        param.put("relateTypeId", relateTypeId);
        Object obj = getSqlMapClientTemplate().queryForObject("query-totalzan",
            param);
        return obj == null ? 0 : (int) obj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Shop> queryAllShopByStatus(int status, String shopName) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("status", status);
        param.put("shopName", shopName);
        return getSqlMapClientTemplate().queryForList("query-allshop-bystatus",
            param);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Integer> querySignMap(String username) {
        return getSqlMapClientTemplate().queryForMap("query-signmap", username,
            "username", "daynum");
    }

    @Override
    public void updateUserSignByUsername(String username, Integer daynum) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("daynum", daynum);
        param.put("username", username);
        getSqlMapClientTemplate().update("update-usersign-byusername", param);
    }

    @Override
    public void insertShop(String username, String shopName, int shopType,
            int shopLevel, String shopDesc, String shopAddr, int status,
            String nowdate) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("shopName", shopName);
        param.put("shopType", shopType);
        param.put("shopLevel", shopLevel);
        param.put("shopDesc", shopDesc);
        param.put("shopAddr", shopAddr);
        param.put("status", status);
        param.put("nowdate", nowdate);
        getSqlMapClientTemplate().insert("insert-shop", param);
    }

    @Override
    public Integer queryShopCountByUsername(String username) {
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-shopcount-byusername", username);
        return obj == null ? 0 : (Integer) obj;
    }

    @Override
    public Integer queryShopCountByUsername(int shopId, String username) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("shopId", shopId);
        param.put("username", username);
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-shopcount-byshopidusername", param);
        return obj == null ? 0 : (Integer) obj;
    }

    @Override
    public void insertApplyFriend(String username, String applyusername,
            String nowdate) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("applyTo", applyusername);
        param.put("nowdate", nowdate);
        getSqlMapClientTemplate().insert("insert-applyfriend", param);
    }

    @Override
    public int queryApplyFriendApplyStatus(String username, String applyTo) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("applyTo", applyTo);
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-applyfriend-applystatus", param);
        return obj == null ? 0 : (Integer) obj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ApplyFriend> queryApplyFriendByApplyTo(String applyTo) {
        return getSqlMapClientTemplate()
            .queryForList("query-applyfriend-byapplyto", applyTo);
    }

    @Override
    public void updateApplyFriendByUsername(String username, String applyTo,
            int applyStatus, String nowdate) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("applyTo", applyTo);
        param.put("applyStatus", applyStatus);
        param.put("nowdate", nowdate);
        getSqlMapClientTemplate().update("update-applyfriend-byusername",
            param);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ApplyFriend> queryApplyFriendByUsername(String username,
            int applyStatus) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("applyStatus", applyStatus);
        return getSqlMapClientTemplate()
            .queryForList("query-applyfriend-byusername", param);
    }

    @Override
    public Shop queryShopById(int shopid) {
        Object obj = getSqlMapClientTemplate().queryForObject("query-shop-byid",
            shopid);
        return obj == null ? null : (Shop) obj;
    }

    @Override
    public Shop queryShopByUsername(String username) {
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-shop-byusername", username);
        return obj == null ? null : (Shop) obj;
    }

    @Override
    public void updateShopByshopid(int shopId, String username, int shopType,
            int shopLevel, String shopDesc, String shopAddr, int status,
            String nowdate) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("shopId", shopId);
        param.put("username", username);
        param.put("shopType", shopType);
        param.put("shopLevel", shopLevel);
        param.put("shopDesc", shopDesc);
        param.put("shopAddr", shopAddr);
        param.put("status", status);
        param.put("nowdate", nowdate);
        getSqlMapClientTemplate().update("update-shop-byshopid", param);
    }

    @Override
    public int queryHibarTotalUsers() {
        Object obj = getSqlMapClientTemplate()
            .queryForObject("query-hibar-totalusers");
        return obj == null ? null : (Integer) obj;
    }

}
