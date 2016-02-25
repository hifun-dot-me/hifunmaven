package com.hifun.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Jsoup工具类
* @ClassName: JsoupUtil 
* @Description:  
* @author yuexia
* @date 2016年1月22日 下午2:47:07 
*
 */
public class JsoupUtil {

	private static final String ST_PATH = "http://www.thfund.com.cn/";			//请求路径
	private static final String ST_METHOD = "GET";								//请求方法
	private static final int ST_TIMEOUT = 5000;									//请求时间
	private static final int ST_CODE = 200;										//成功代码   200表示成功
	
	//**********************以下为一些选择器的使用方式，如需要可自行添加**********************
	
	//Jsoup解析html
	public static String getMoneyDataJsonByJsoup() throws IOException {
		StringBuffer resultData = new StringBuffer();
		//抓取网页
		Document document = Jsoup.connect(ST_PATH).timeout(0).get();
		resultData.append("{\"getMoneyPer1W\":\"");
		//jsoup选择器   从左到右依次为--->id选择   子节点选择器   下标选择器
		Elements element1 = document.select("table#zc3 tr:eq(1) td:eq(2) a");
		resultData.append(element1.text()).append("\", \"getMoneyRate\":\"");
		Elements element2 = document.select("table#zc3 tr:eq(1) td:eq(3)");
		String eleText2 = element2.text();
		resultData.append(eleText2.substring(1, eleText2.length())).append("\"}");
		return resultData.toString();
	}
	
	//Jsoup解析html
	public static String[] getMoneyDataArrByJsoup() throws IOException {
		String[] resultData = new String[2];
		//抓取网页
		Document document = Jsoup.connect(ST_PATH).timeout(0).get();
//		Document document = Jsoup.parse(getHttp());
		//jsoup选择器   从左到右依次为--->id选择   子节点选择器   下标选择器
		Elements element1 = document.select("table#zc3 tr:eq(1) td:eq(2) a");
		resultData[0] = element1.text();
		Elements element2 = document.select("table#zc3 tr:eq(1) td:eq(3)");
		String eleText2 = element2.text();
		resultData[1] = eleText2.substring(1, eleText2.length());
		return resultData;
	}
	
	//http请求获取网页内容   输出网页String格式
	//Document document = Jsoup.connect(ST_PATH).timeout(0).get();
	//jsoup可直接获取
	@SuppressWarnings("unused")
	private static String getHttp() throws IOException {
		StringBuffer resultHtml = new StringBuffer();
		URL url = new URL(ST_PATH);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(ST_TIMEOUT);
		conn.setRequestMethod(ST_METHOD);
		if(conn.getResponseCode()==ST_CODE){
			String len;
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			while((len = reader.readLine()) != null){
				resultHtml.append(len);
			}
		}
		return resultHtml.toString();
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(getMoneyDataJsonByJsoup());
	}
}
