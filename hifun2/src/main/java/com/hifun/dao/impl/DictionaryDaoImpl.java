package com.hifun.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hifun.bean.ShopType;
import com.hifun.dao.BaseDao;
import com.hifun.dao.IDictionaryDao;

@Component
public class DictionaryDaoImpl extends BaseDao implements IDictionaryDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<ShopType> queryShopTypeListValidate() {
        return getSqlMapClientTemplate()
            .queryForList("query-shoptypelist-validate");
    }

}
