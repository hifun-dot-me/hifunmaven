package com.hifun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hifun.service.IExtendInterfaceService;

@Controller
@RequestMapping(value = "/extendInterface")
public class ExtendInterfaceController extends BaseController {

    @Autowired
    private IExtendInterfaceService extendInterfaceService;

    @RequestMapping(value = "/linkWX.do", method = RequestMethod.GET)
    @ResponseBody
    public String linkWX(
            @RequestParam(value = "token", required = false) String token) {
        System.out.println("token===================" + token);
        if ("hifuntoken_1991".equals(token)) {

        }
        return token;
    }

}
