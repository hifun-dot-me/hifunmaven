package com.hifun.base.session;

/**
 * 对象本地线程存储
 * @author: yuexia 
 * @since: 2016年1月29日 下午11:34:59 
 * @history:
 */
public class UserDetailHolder {

    public static final ThreadLocal<AUserDetail> userDetail = new ThreadLocal<AUserDetail>();

    public static AUserDetail getUserDetail() {
        return userDetail.get();
    }

    public static void setUserDeail(AUserDetail user) {
        userDetail.set(user);
    }

    public static void remove() {
        userDetail.remove();
    }
}
