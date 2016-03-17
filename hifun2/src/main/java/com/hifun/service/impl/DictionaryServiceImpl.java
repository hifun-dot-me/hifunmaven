package com.hifun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hifun.bean.ShopType;
import com.hifun.dao.IDictionaryDao;
import com.hifun.service.BaseService;
import com.hifun.service.IDictionaryService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DictionaryServiceImpl extends BaseService
        implements IDictionaryService {

    @Autowired
    private IDictionaryDao dictionaryDao;

    @Override
    public List<ShopType> queryShopTypeListValidate() {
        return dictionaryDao.queryShopTypeListValidate();
    }

}
