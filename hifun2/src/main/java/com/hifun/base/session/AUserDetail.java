package com.hifun.base.session;

/**
 * 会员抽象类，子类会员对象必须继承此对象，否则无法放入会话中
 * @author: yuexia 
 * @since: 2016年1月29日 下午11:34:19 
 * @history:
 */
public abstract class AUserDetail {

    /**
     * 
     * <一句话功能简述> 判断会员 登录会话是否有效，子类必须覆盖此方法 <功能详细描述>
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public Boolean isValid() {
        return Boolean.TRUE;
    }

}
