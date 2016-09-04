package com.hifun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hifun.service.IHeadService;

@Controller
@RequestMapping(value = "/hibar")
public class HibarController extends BaseController {

    @Autowired
    private IHeadService headService;

    @RequestMapping(value = "/firstpage.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView hibarfirstpage() {
        ModelAndView view = new ModelAndView("/hibar");
        return view;
    }

    @RequestMapping(value = "/hifunarea.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView hibarhifunarea() {
        ModelAndView view = new ModelAndView("/hibarhifunarea");
        return view;
    }

    @RequestMapping(value = "/talkarea.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView hibartalkarea() {
        ModelAndView view = new ModelAndView("/hibartalkarea");
        return view;
    }

    @RequestMapping(value = "/fivetalkarea.do", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView hibarfivetalkarea() {
        ModelAndView view = new ModelAndView("/hibarfivetalkarea");
        return view;
    }

    @RequestMapping(value = "/querytotalusers.do", method = RequestMethod.POST)
    @ResponseBody
    public int queryTotalUsers() {
        try {
            return headService.queryHibarTotalUsers();
        } catch (Exception e) {
            return 0;
        }
    }

}
