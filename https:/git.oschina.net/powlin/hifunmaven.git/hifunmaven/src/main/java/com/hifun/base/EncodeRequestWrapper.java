package com.hifun.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.hifun.util.EncodeChangeUtil;

public class EncodeRequestWrapper extends HttpServletRequestWrapper {

    // 不做过滤的参数名称
    // 1.密码
    // 2. ueditor-html文本
    private static final String VALIDATE_PARAMETERS = "password, content";

    public EncodeRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (!VALIDATE_PARAMETERS.contains(name) && values != null) {
            for (int i = 0; i < values.length; i++) {
                values[i] = EncodeChangeUtil.change(values[i]);
            }
        }
        return values;
    }

}
