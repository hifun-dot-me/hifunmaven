package com.hifun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hifun.bean.Dictionary;
import com.hifun.service.IDictionaryService;

@Controller
@RequestMapping(value = "/dictionary")
public class DictionaryController extends BaseController {

    @Autowired
    private IDictionaryService dictionaryService;

    @RequestMapping(value = "/querylist.do", method = RequestMethod.GET)
    @ResponseBody
    public List<Dictionary> querydictionarylist(
            @RequestParam(value = "dictionaryType", required = true) String dictionaryType) {
        return dictionaryService.queryDictionaryListValidate(dictionaryType);
    }

}
