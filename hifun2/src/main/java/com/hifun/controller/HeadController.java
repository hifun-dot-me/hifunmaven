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
import com.hifun.bean.Shop;
import com.hifun.bean.TimeEnum;
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
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
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
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
            // 判断今日是否已经签到
            view.addObject("isSign",
                headService.queryTodayIsSign(
                    ((SessionUser) sessionProvider.getUserDetail())
                        .getUsername(),
                DateUtil.getNowTimeString(TimeEnum.DATE.getFormat())));
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
            // 查询今日是否已签到
            Integer issign = headService.querySignCount(
                DateUtil.getNowTimeString(TimeEnum.DATE.getFormat()),
                ((SessionUser) sessionProvider.getUserDetail()).getUsername());
            // 如果签到过
            if (issign > 0) {
                return -1;
            }
            // 查询今日总签到数
            Integer signcount = headService.querySignCount(
                DateUtil.getNowTimeString(TimeEnum.DATE.getFormat()));
            // 保存当前签到信息
            headService.insertSign(
                ((SessionUser) sessionProvider.getUserDetail()).getUsername(),
                DateUtil.getNowTimeString(TimeEnum.TIME.getFormat()),
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
                DateUtil.getNowTimeString(TimeEnum.TIME.getFormat()));
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "/submithifunplayground.do", method = RequestMethod.POST)
    @ResponseBody
    public int submithifunplayground(
            @RequestParam(value = "content", required = false) String content) {
        // session不为空
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
            headService.insertHiPlayground(content,
                ((SessionUser) sessionProvider.getUserDetail()).getUsername(),
                DateUtil.getNowTimeString(TimeEnum.TIME.getFormat()));
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
    public ModelAndView showh2(
            @RequestParam(value = "shopName", required = false) String shopName) {
        ModelAndView view = new ModelAndView("/hifunplayground");
        List<Shop> shoplist = headService
            .queryAllShopByStatus(AuditEnum.Y.getStatus(), shopName);
        view.addObject("shoplist", shoplist);
        view.addObject("shopName", shopName);
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
                DateUtil.getNowTimeString(TimeEnum.DATE.getFormat()), username,
                1);
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

    @RequestMapping(value = "/uploadhifunplayground.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showh8() {
        ModelAndView view = new ModelAndView("/uploadhifunplayground");
        return view;
    }

    @RequestMapping(value = "/shopregister.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showh9() {
        ModelAndView view = new ModelAndView("/shopregister");
        return view;
    }

    @RequestMapping(value = "/shopregister.do", method = RequestMethod.POST)
    @ResponseBody
    public int shopregister(
            @RequestParam(value = "shopName", required = true) String shopName,
            @RequestParam(value = "shopType", required = true) int shopType,
            @RequestParam(value = "shopLevel", required = true) int shopLevel,
            @RequestParam(value = "shopDesc", required = true) String shopDesc,
            @RequestParam(value = "shopAddr", required = true) String shopAddr) {
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
            String username = ((SessionUser) sessionProvider.getUserDetail())
                .getUsername();
            Integer count = headService.queryShopCountByUsername(username);
            // 用户名已注册商家
            if (count > 0) {
                return 2;
            }
            try {
                headService.insertShop(username, shopName, shopType, shopLevel,
                    shopDesc, shopAddr, AuditEnum.Y.getStatus(),
                    DateUtil.getNowTimeString(TimeEnum.TIME.getFormat()));
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
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
                DateUtil.getNowTimeString(TimeEnum.TIME.getFormat()),
                evaluateId, evaluateTypeId, relateTypeId);
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "/viewhiletter.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView viewhiletter() {
        ModelAndView view = new ModelAndView("/viewhiletter");
        return view;
    }

    @RequestMapping(value = "/systemsetup.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView systemsetup() {
        ModelAndView view = new ModelAndView("/systemsetup");
        return view;
    }

    @RequestMapping(value = "/showapplyfriend.do", method = RequestMethod.GET)
    @ResponseBody
    public int showapplyfriend(
            @RequestParam(value = "applyTo", required = true) String applyTo) {
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
            String username = ((SessionUser) sessionProvider.getUserDetail())
                .getUsername();
            int count = headService.queryApplyFriendCount(username, applyTo);
            if (count > 0) {
                // 已申请
                return 2;
            }
            return username.equals(applyTo) ? -1 : 1;
        }
        return 0;
    }

    @RequestMapping(value = "/applyfriend.do", method = RequestMethod.GET)
    @ResponseBody
    public int applyfriend(
            @RequestParam(value = "applyTo", required = true) String applyTo) {
        if (sessionProvider != null
                && sessionProvider.getUserDetail() != null) {
            String username = ((SessionUser) sessionProvider.getUserDetail())
                .getUsername();
            try {
                headService.insertApplyFriend(username, applyTo,
                    DateUtil.getNowTimeString(TimeEnum.TIME.getFormat()));
                return 1;
            } catch (Exception e) {
                return -1;
            }
        }
        return 0;
    }

}
