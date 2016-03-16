package com.hifun.base;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hifun.bean.TimeEnum;

/**
 * Jackson
 * @author: yuexia 
 * @since: 2016年1月29日 下午11:36:21 
 * @history:
 */
public abstract class JacksonUtils {

    private static final Logger logger = LoggerFactory
        .getLogger(JacksonUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 设置默认日期格式
        objectMapper.setDateFormat(new SimpleDateFormat(TimeEnum.DATE.getFormat()));
        // 提供其它默认设置
        objectMapper
            .setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
    }

    /**
     *  转换对象到json 格式字符串，如果转换失败 返回null
     * @param object
     * @return
     */
    public final static String toJsonString(Object object,
            String... properties) {
        try {
            SimpleFilterProvider fileter = new SimpleFilterProvider();
            fileter.addFilter(AnnotationUtils
                .findAnnotation(object.getClass(), JsonFilter.class).value(),
                SimpleBeanPropertyFilter.filterOutAllExcept(properties));
            return objectMapper.writer(fileter).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("转换对象【" + object.toString() + "】到json格式字符串失败：" + e);
            return null;
        }
    }

    public final static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("转换对象【" + object.toString() + "】到json格式字符串失败：" + e);
            return null;
        }
    }
}
