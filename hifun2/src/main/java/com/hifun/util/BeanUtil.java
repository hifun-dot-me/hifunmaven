package com.hifun.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据数据库表生成JAVA实体类
 * 执行main方法即可
* @ClassName: BeanUtil 
* @author dp 
* @date 2016年3月17日 下午5:04:51 
*
 */
public class BeanUtil {
	
	private static Connection conn;
	private static Map<String, String> mysql2javaMap = new HashMap<String, String>();
	private static final String SPLIT_CHAR = "_";
	private static final String GET_STR = "get";
	private static final String SET_STR = "set";
	
	static{
		conn = DBUtil.getConnection();
		//mysql type - java type
		mysql2javaMap.put("INT", "java.lang.Integer");
		mysql2javaMap.put("VARCHAR", "java.lang.String");
		mysql2javaMap.put("DATETIME", "java.util.Date");
	}
	
	/**
	 * 根据数据库表生成实体类
	 * @param tableName
	 * @return
	 */
	public static String generateBeanText(String tableName) throws Exception{
		StringBuilder result = new StringBuilder("public class ");
		ResultSet rs = conn.getMetaData().getColumns(null, "%", tableName, "%");
		String javaclass = changeChar(tableName, SPLIT_CHAR);
		result.append(javaclass + "{\r\n");
		while(rs.next()){
			//获取字段名称
			String columnName = rs.getString("COLUMN_NAME");
			//获取字段类型
			String typeName = rs.getString("TYPE_NAME");
			//private Integer id;
			result.append("\tprivate " + mysql2javaMap.get(typeName) + " " + columnName + ";\r\n");
			//public Integer getId(){
			//	return id;
			//}
			result.append("\tpublic " + mysql2javaMap.get(typeName) + " " + GET_STR + upperCaseFirst(columnName) + "(){\r\n");
			result.append("\t\t return " + columnName + ";\r\n");
			result.append("\t}\r\n");
			//public void setId(Integer id){
			//	this.id = id;
			//}
			result.append("\tpublic void " + SET_STR + upperCaseFirst(columnName) + "(" + 
					mysql2javaMap.get(typeName) + " " + columnName + "){\r\n");
			result.append("\t\t this." + columnName + " = " + columnName + ";\r\n");
			result.append("\t}\r\n");
//			System.out.println(typeName + "   " + columnName);
		}
		result.append("}\r\n");
		return result.toString();
	}
	
	/**
	 * 去除指定字符，将字符后首位字母转化为大写
	 * @param tableName
	 * @return
	 */
	private static String changeChar(String tableName, String splitchar) {
		if(tableName.indexOf(splitchar) == -1){
			return upperCaseFirst(tableName);
		}
		String[] split = tableName.split(splitchar);
		StringBuilder javaclass = new StringBuilder();
		for(int i = 0;i < split.length;i++){
			javaclass.append(upperCaseFirst(split[i]));
		}
		return javaclass.toString();
	}
	
	/**
	 * 字符串首字母转化为大写
	 * @param property
	 * @return
	 */
	private static String upperCaseFirst(String property) {
		if(property == null || "".equals(property)){
			return "";
		}
		//转为字符数组
		char[] ca = property.toCharArray();
		char c = ca[0];
		//第一位字母为小写字母，则做ASCII码 - 32转为大写，其他字符不做处理
		ca[0] = (c >= 'a' && c <= 'z') ? (char)(c - 32) : c;
		return new String(ca);
	}

	/**
	 * 生成文件
	 * @param text 写入文本
	 * @param dir 目标文件夹
	 * @param fileName 目标文件名 
	 * @throws Exception
	 */
	private static void writeFile(String text, String dir, String fileName) throws Exception{
		File d = new File(dir);
		if(!d.exists()){
			d.mkdir();
		}
		File f = new File(dir + "\\" + fileName);
		if(!f.exists()){
			f.createNewFile();
		}
		byte[] contentInBytes = text.getBytes();
		OutputStream os = new FileOutputStream(f);
		os.write(contentInBytes);
		os.flush();
		//关闭流
		os.close();
	}
	
	public static void main(String[] args) throws Exception{
		//所有需要生成实体类的数据库表数组
		String[] findTables = {"test1", "test2"};
		for(String findTable : findTables){
			String text = generateBeanText(findTable);
			writeFile(text, "D:\\BeanGenerateUtil", findTable + ".txt");
		}
		System.out.println("文件生成成功!");
	}
	
}
