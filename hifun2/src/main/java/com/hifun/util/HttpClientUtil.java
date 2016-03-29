package com.hifun.util;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * httpClient工具类
* @ClassName: HttpClientUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author dp 
* @date 2016年3月11日 上午9:14:56 
*
 */
public class HttpClientUtil {

	// 登录URL
	private static final String LOGIN_URL = "http://localhost/userAuthen/login.do";
	// 登录后需访问的URL
	private static final String DATA_URL = "http://localhost/headpage/signin.do";
	
	/**
	 * 签到 - 后续再做封装
	 */
	public static void doSign(String username, String password){

		HttpClient httpClient = new HttpClient();

		// 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
		PostMethod postMethod = new PostMethod(LOGIN_URL);

		// 设置登陆时要求的信息，用户名和密码
		NameValuePair[] data = { new NameValuePair("username", username),
				new NameValuePair("password", password) };
		postMethod.setRequestBody(data);
		postMethod.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf8");
		try {
			// 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
			httpClient.getParams().setCookiePolicy(
					CookiePolicy.BROWSER_COMPATIBILITY);
			httpClient.executeMethod(postMethod);
			// 获得登陆后的 Cookie
			Cookie[] cookies = httpClient.getState().getCookies();
			StringBuffer tmpcookies = new StringBuffer();
			for (Cookie c : cookies) {
				tmpcookies.append(c.toString() + ";");
			}
			// 进行登陆后的操作
			PostMethod getMethod = new PostMethod(DATA_URL);
			// 每次访问需授权的网址时需带上前面的 cookie 作为通行证
			getMethod.setRequestHeader("cookie", tmpcookies.toString());
			// 你还可以通过 PostMethod/GetMethod 设置更多的请求后数据
			// 例如，referer 从哪里来的，UA 像搜索引擎都会表名自己是谁，无良搜索引擎除外
			// postMethod.setRequestHeader("Referer", "http://www.cc");
			// postMethod.setRequestHeader("User-Agent", "www Spot");
			httpClient.executeMethod(getMethod);
			// 打印出返回数据，检验一下是否成功
			String text = getMethod.getResponseBodyAsString();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		doSign("", "");
	}
}