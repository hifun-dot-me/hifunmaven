package com.hifun.service;

import java.util.List;

import com.hifun.bean.ShopType;

public interface IDictionaryService {

    /**
     * 查询所有生效的商家类型
     * @return 
     * @create: 2016年3月17日 下午9:30:03 yuexia
     * @history:
     */
    List<ShopType> queryShopTypeListValidate();

}
