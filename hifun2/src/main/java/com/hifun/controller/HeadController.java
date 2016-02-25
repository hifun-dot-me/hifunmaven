package com.hifun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hifun.base.session.SessionUser;
import com.hifun.bean.AuditEnum;
import com.hifun.bean.Banner;
import com.hifun.bean.HiThings;
import com.hifun.bean.Menu;
import com.hifun.service.IHeadService;
import com.hifun.util.DateUtil;

@Controller
@RequestMapping(value = "/headpage")
public class HeadController extends BaseController {

    @Autowired
    private IHeadService headService;

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showMain() {
        ModelAndView view = new ModelAndView("/index");
        // 获取生效的菜单
        List<Menu> menulist = headService.queryMenuValidateList();
        view.addObject("menulist", menulist);
        // 记录session
        view.addObject("sessionProvider", sessionProvider);
        if (sessionProvider.getUserDetail() != null) {
            view.addObject("username",
                ((SessionUser) sessionProvider.getUserDetail()).getUsername());
        }
        return view;
    }

    @RequestMapping(value = "/firstpage.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showFirstpage() {
        ModelAndView view = new ModelAndView("/firstpage");
        // 获取生效的banner-按时间倒序最多6个
        List<Banner> bannerlist = headService.queryBannerValidateList();
        view.addObject("bannerlist", bannerlist);
        // 查询前十的数据库用户
        List<SessionUser> toptenlist = headService.queryTopTenUsers();
        view.addObject("toptenlist", toptenlist);
        if (sessionProvider.getUserDetail() != null) {
            // 判断今日是否已经签到
            view.addObject("isSign",
                headService.queryTodayIsSign(
                    ((SessionUser) sessionProvider.getUserDetail())
                        .getUsername(),
                DateUtil.getNowTimeString("yyyy-MM-dd")));
        } else {
            view.addObject("isSign", 0);
        }
        return view;
    }

    @RequestMapping(value = "/signin.do", method = RequestMethod.POST)
    @ResponseBody
    public int signin() {
        // session不为空
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
            // 查询今日总签到数
            Integer signcount = headService
                .querySignCount(DateUtil.getNowTimeString("yyyy-MM-dd"));
            // 查询今日是否已签到
            Integer issign = headService.querySignCount(
                DateUtil.getNowTimeString("yyyy-MM-dd"),
                ((SessionUser) sessionProvider.getUserDetail()).getUsername());
            // 如果签到过
            if (issign == 1) {
                return -1;
            }
            // 保存当前签到信息
            headService.insertSign(
                ((SessionUser) sessionProvider.getUserDetail()).getUsername(),
                DateUtil.getNowTimeString("yyyy-MM-dd HH:MM:ss"),
                signcount + 1);
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "/submithithings.do", method = RequestMethod.POST)
    @ResponseBody
    public int submithithings(
            @RequestParam(value = "content", required = false) String content) {
        // session不为空
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
            headService.insertHiThings(content,
                ((SessionUser) sessionProvider.getUserDetail()).getUsername(),
                DateUtil.getNowTimeString("yyyy-MM-dd HH:MM:ss"));
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "/show.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showHeadPage() {
        ModelAndView view = new ModelAndView("/index");
        return view;
    }

    @RequestMapping(value = "/hifunplayground.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showh2() {
        ModelAndView view = new ModelAndView("/hifunplayground");
        return view;
    }

    @RequestMapping(value = "/hibar.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showh3() {
        ModelAndView view = new ModelAndView("/hibar");
        return view;
    }

    @RequestMapping(value = "/hithings.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showh4() {
        ModelAndView view = new ModelAndView("/hithings");
        List<HiThings> hithingslist;
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
            String username = ((SessionUser) sessionProvider.getUserDetail())
                .getUsername();
            hithingslist = headService.queryHiThingsByStatus(username,
                AuditEnum.Y.getStatus());
            // 查询今天所有的赞数
            int count = headService.queryTotalZan(
                DateUtil.getNowTimeString("yyyy-MM-dd"), username, 1);
            view.addObject("totalzan", count);
        } else {
            hithingslist = headService
                .queryHiThingsByStatus(AuditEnum.Y.getStatus());
            view.addObject("totalzan", "登录查看");
        }
        view.addObject("hithingslist", hithingslist);
        return view;
    }

    @RequestMapping(value = "/hisupermarket.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showh5() {
        ModelAndView view = new ModelAndView("/hisupermarket");
        return view;
    }

    @RequestMapping(value = "/donate.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showh6() {
        ModelAndView view = new ModelAndView("/donate");
        return view;
    }

    @RequestMapping(value = "/uploadhithings.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showh7() {
        ModelAndView view = new ModelAndView("/uploadhithings");
        return view;
    }

    @RequestMapping(value = "/evaluate.do", method = RequestMethod.POST)
    @ResponseBody
    public int evaluate(
            @RequestParam(value = "evaluateId", required = true) int evaluateId,
            @RequestParam(value = "evaluateTypeId", required = true) int evaluateTypeId,
            @RequestParam(value = "relateTypeName", required = true) String relateTypeName) {
        int relateTypeId = headService
            .queryEvaluateRelateIdByName(relateTypeName);
        // 无法查询到该名称
        if (relateTypeId == 0) {
            return -3;
        }
        // 必须是赞或者踩
        if (evaluateTypeId != 1 && evaluateTypeId != -1) {
            return -2;
        }
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
            String username = ((SessionUser) sessionProvider.getUserDetail())
                .getUsername();
            // 查询是否赞过或踩过
            int count = headService.queryEvaluateCount(evaluateId, username);
            if (count > 0) {
                return -1;
            }
            headService.insertEvaluate(username,
                DateUtil.getNowTimeString("yyyy-MM-dd HH:mm:ss"), evaluateId,
                evaluateTypeId, relateTypeId);
            return 1;
        }
        return 0;
    }

}
