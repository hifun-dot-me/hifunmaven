package com.hifun.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hifun.service.BaseService;
import com.hifun.service.IWebSocketService;

@Service("webSocketService")
@Transactional(propagation = Propagation.REQUIRED)
public class WebSocketServiceImpl extends BaseService
        implements IWebSocketService {

}
