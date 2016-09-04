package com.hifun.util;

/**
 * html生成工具类
 * @author yuexia
 *
 */
public class HtmlUtil {

    private static final String HTML_BR_TAG = "<br/>";

    /**
     * 字符串保存<br/>
     * @param ms
     * @param position
     * @return 
     * @create: 2016年9月4日 下午1:59:52 yuexia
     * @history:
     */
    public static void insertBr(StringBuilder ms, int position) {
        ms.insert(position, HTML_BR_TAG);
    }

    /**
     * 字符串保存<br/> (循环)
     * @param message
     * @param position
     * @return 
     * @create: 2016年9月4日 下午1:59:52 yuexia
     * @history:
     */
    public static String insertBrLoop(String message, int position) {
        if (message == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(message);
        for (int i = sb.length() - 1; i > 0; i--) {
            if (i % position == 0) {
                insertBr(sb, i);
            }
        }
        return sb.toString();
    }

}
