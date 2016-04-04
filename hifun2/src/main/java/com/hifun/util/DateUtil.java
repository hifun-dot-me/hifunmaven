package com.hifun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hifun.bean.data.TimeEnum;

/**
 * 日期工具类
 * @author yuexia
 *
 */
public class DateUtil {

    /**
     * 获取当前时间的字符串
     * @param format 格式
     * @return
     */
    public static String getNowTimeString(String format) {
        return getTimeString(new Date(), format);
    }

    /**
     * 获取传入时间的字符串
     * @param date 日期
     * @param format 格式
     * @return
     */
    public static String getTimeString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date getTimeDate(String date) {
        try {
            return new SimpleDateFormat(TimeEnum.TIME.getFormat()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

}
