package com.hifun.base;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.ServletContextAware;

/**
 * 配置静态文件工具类
 * @author: yuexia 
 * @since: 2016年1月29日 下午11:35:21 
 * @history:
 */
public class ApplicationProperties implements ServletContextAware {

    private ServletContext servletContext;

    @Value("${web.basePath}")
    private String basePath;

    @Value("${web.dojoUrl}")
    private String dojoUrl;

    @Value("${web.jsVersion}")
    private String jsVersion;

    /**
     * cook配置
     */
    @Value("${web.cookies.path}")
    private String webCookiesPath;

    /**
     * cook配置
     */
    @Value("${web.cookies.domain}")
    private String webCookiesDomain;

    @Value("${web.resRelease}")
    private String resRelease;

    @Value("${web.picUrl}")
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getResRelease() {
        return resRelease;
    }

    public void setJsVersion(String jsVersion) {
        this.jsVersion = jsVersion;
    }

    public String getJsVersion() {
        return jsVersion;
    }

    public void setResRelease(String resRelease) {
        this.resRelease = resRelease;
    }

    public String getWebCookiesPath() {
        return webCookiesPath;
    }

    public void setWebCookiesPath(String webCookiesPath) {
        this.webCookiesPath = webCookiesPath;
    }

    public String getWebCookiesDomain() {
        return webCookiesDomain;
    }

    public void setWebCookiesDomain(String webCookiesDomain) {
        this.webCookiesDomain = webCookiesDomain;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getDojoUrl() {
        return dojoUrl;
    }

    public void setDojoUrl(String dojoUrl) {
        this.dojoUrl = dojoUrl;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    @Override
    public void setServletContext(ServletContext context) {
        context.setAttribute("basePath", basePath);
        context.setAttribute("dojoUrl", dojoUrl);

        context.setAttribute("resRelease", resRelease);
        context.setAttribute("jsVersion", jsVersion);

        context.setAttribute("picUrl", picUrl);
    }

}
