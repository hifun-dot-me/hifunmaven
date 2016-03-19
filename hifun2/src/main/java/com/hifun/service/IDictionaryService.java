package com.hifun.service;

import java.util.List;

import com.hifun.bean.Dictionary;

public interface IDictionaryService {

    /**
     * 查询当前类型下所有字典数据
     * @param dictionaryType
     * @return 
     * @create: 2016年3月17日 下午9:30:03 yuexia
     * @history:
     */
    List<Dictionary> queryDictionaryListValidate(String dictionaryType);

}
