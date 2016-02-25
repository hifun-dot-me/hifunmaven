package com.hifun.util;

import java.util.Random;

/**
 * 随机数生成工具类-可用于生成验证码
* @ClassName: RandomUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author dp 
* @date 2016年1月22日 下午3:07:30 
*
 */
public class RandomUtil {

	private static final String randStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static String getRandom(int num) {
		Random random = new Random();
		int nextInt = 0;
		StringBuilder result = new StringBuilder();
		for(int i = 0;i < num; i++){
			nextInt = random.nextInt(randStr.length());
			result.append(randStr.charAt(nextInt));
		}
		return result.toString();
	}

}
