package com.hifun.base.converters;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 自定义json数据返回格式，增加 属性字段 success,data
 * @author: yuexia 
 * @since: 2016年1月29日 下午11:32:19 
 * @history:
 */
public class CustomMappingJackson2HttpMessageConverter
        extends MappingJackson2HttpMessageConverter {

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        JsonObject jsonObject = new JsonObject(object);
        super.writeInternal(jsonObject, outputMessage);
        // super.writeInternal(object, outputMessage);
    }
}
