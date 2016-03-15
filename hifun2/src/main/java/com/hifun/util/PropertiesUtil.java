package com.hifun.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件
* @ClassName: PropertiesUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author dp 
* @date 2016年3月8日 下午2:47:58 
*
 */
public class PropertiesUtil {

	public static Properties prop;
	public static final String FILE_PATH = "/WEB-INF/conf/jdbc.properties";
	
	static{
		prop = new Properties();
	}
	
	public static Properties returnProperties(){
		return prop;
	}
	
	public static String returnParam(String param){
		InputStream in = PropertiesUtil.class.getResourceAsStream(FILE_PATH);
		Properties p = returnProperties();
		try {
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(param);
	}
	
	public static void main(String[] args) {
		System.out.println(returnParam("url"));
	}
}
