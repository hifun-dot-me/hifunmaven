package com.hifun.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.hifun.util.EncodeChangeUtil;

public class EncodeRequestWrapper extends HttpServletRequestWrapper {

	private static final String VALIDATE_PARAMETER = "username";
	
    public EncodeRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    
    @Override
    public String[] getParameterValues(String name) {
    	String[] values = super.getParameterValues(name);
    	if(VALIDATE_PARAMETER.equals(name) && values != null){
    		for (int i = 0; i < values.length; i++) {
                values[i] = EncodeChangeUtil.change(values[i]);
            }
    	}
    	return values;
    }

}
