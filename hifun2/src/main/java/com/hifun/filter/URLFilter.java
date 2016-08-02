package com.hifun.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hifun.base.EncodeRequestWrapper;

@WebFilter("/URLFilter")
public class URLFilter implements Filter {

    public URLFilter() {

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 获取url
        String url = req.getRequestURI()
            .substring(req.getContextPath().length());
        if (url.equals("/")) {// 访问网站根目录
            res.sendRedirect(req.getContextPath() + "/views/welcome.jsp");
            return;
        }
        req = new EncodeRequestWrapper(req);
        chain.doFilter(req, res);
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

}
