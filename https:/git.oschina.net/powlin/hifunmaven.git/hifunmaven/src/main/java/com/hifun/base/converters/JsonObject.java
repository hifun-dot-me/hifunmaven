package com.hifun.base.converters;

/**
 * JSON格式数据返回对象,封装controller 返回的对象
 * @author: yuexia 
 * @since: 2016年1月29日 下午11:31:57 
 * @history:
 */
public class JsonObject {

    /**
     * 请求结果
     */
    private Boolean success = Boolean.TRUE;

    /**
     * 请求结果说明
     */
    private String msg;

    /**
     * controller 方法返回数据对象
     */
    private Object data;

    public JsonObject(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
