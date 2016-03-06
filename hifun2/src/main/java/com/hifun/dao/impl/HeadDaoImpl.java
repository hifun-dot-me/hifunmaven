package com.hifun.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hifun.base.session.SessionUser;
import com.hifun.bean.Banner;
import com.hifun.bean.HiPlayground;
import com.hifun.bean.HiThings;
import com.hifun.bean.Menu;
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
    public List<HiPlayground> queryAllHifunPlayground() {
        return getSqlMapClientTemplate()
            .queryForList("query-allhifunplayground");
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

}
