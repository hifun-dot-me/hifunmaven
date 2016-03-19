package com.hifun.dao;

import java.util.List;

import com.hifun.bean.Dictionary;

public interface IDictionaryDao {

    /**
     * 查询当前类型下所有字典数据
     * @param dictionaryType
     * @return 
     * @create: 2016年3月17日 下午9:31:33 yuexia
     * @history:
     */
    List<Dictionary> queryDictionaryListValidate(String dictionaryType);

}
