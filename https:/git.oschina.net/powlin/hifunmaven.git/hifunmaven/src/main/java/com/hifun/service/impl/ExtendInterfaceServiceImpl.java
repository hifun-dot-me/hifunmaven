package com.hifun.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hifun.service.BaseService;
import com.hifun.service.IExtendInterfaceService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExtendInterfaceServiceImpl extends BaseService
        implements IExtendInterfaceService {

}
