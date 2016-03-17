package com.hifun.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

public class DBUtil {
	
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	
	static{
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("conf/jdbc.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		url = p.getProperty("url");
		username = p.getProperty("username");
		password = p.getProperty("password");
		driver = p.getProperty("driver");
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		}
		return conn;
	}
	
}
