package com.hifun.util;

public class EncodeChangeUtil {

    // 原始字符数组
    private static char[] oldchars = { '<', '>', '$', '@', '%', '&', '*', '(',
            ')', '!', '~', '{', '}', '[', ']', '#', '/' };

    // 更改字符数组
    private static char[] newchars = { '＜', '＞', '￥', '＠', '％', '＆', '×', '（',
            '）', '！', '～', '｛', '｝', '【', '】', '＃', '／' };

    public static String change(String parameter) {
        if (parameter == null) {
            return null;
        }
        // 循环字符数组，替换原始字符为新的字符
        for (int i = 0, len = oldchars.length; i < len; i++) {
            parameter = parameter.replace(oldchars[i], newchars[i]);
        }
        return parameter;
    }

    public static void main(String[] args) {
        System.out.println(change("<-[]{}__0000!$%%%$##"));
    }
}
