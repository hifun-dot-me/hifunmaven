package com.hifun.dao;

import java.util.List;

import com.hifun.bean.ShopType;

public interface IDictionaryDao {

    /**
     * 查询所有生效的商家类型
     * @return 
     * @create: 2016年3月17日 下午9:31:33 yuexia
     * @history:
     */
    List<ShopType> queryShopTypeListValidate();

}
